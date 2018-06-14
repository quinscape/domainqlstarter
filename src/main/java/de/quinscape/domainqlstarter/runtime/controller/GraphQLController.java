package de.quinscape.domainqlstarter.runtime.controller;

import de.quinscape.spring.jsview.util.JSONUtil;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class GraphQLController
{
    private final static Logger log = LoggerFactory.getLogger(GraphQLController.class);


    private final GraphQLSchema schema;

    private final GraphQL graphQL;


    @Autowired
    public GraphQLController(
        GraphQLSchema schema
    )
    {
        this.schema = schema;
        this.graphQL = GraphQL.newGraphQL(schema).build();
    }


    @RequestMapping(value = "/graphql", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> serveGraphQL(@RequestBody Map body)
    {
        String query = (String) body.get("query");
        Map<String, Object> variables = (Map<String, Object>) body.get("variables");
        //log.debug("/graphql: query = {}, vars = {}", query, variables);

        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
            .query(query)
            .variables(variables)
            .build();

        ExecutionResult executionResult = graphQL.execute(executionInput);

        // result may contain data and/or errors
        Object result = executionResult.toSpecification();
        return new ResponseEntity<String>(
            JSONUtil.DEFAULT_GENERATOR.forValue(
                result
            ),
            executionResult.getErrors().size() == 0 ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }
}
