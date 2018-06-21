package de.quinscape.domainqlstarter.runtime.service;

import de.quinscape.domainql.annotation.GraphQLField;
import de.quinscape.domainql.annotation.GraphQLLogic;
import de.quinscape.domainql.annotation.GraphQLMutation;
import de.quinscape.domainql.annotation.GraphQLQuery;
import de.quinscape.domainqlstarter.domain.tables.pojos.AppUser;
import de.quinscape.domainqlstarter.domain.tables.pojos.Foo;
import de.quinscape.domainqlstarter.domain.tables.records.FooRecord;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLFieldDefinition;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static de.quinscape.domainqlstarter.domain.Tables.*;

@GraphQLLogic
public class DomainqlstarterLogic
{
    private final static Logger log = LoggerFactory.getLogger(DomainqlstarterLogic.class);


    private final DSLContext dslContext;


    @Autowired
    public DomainqlstarterLogic(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }


    @GraphQLQuery
    public PagedFoos listFoos(
        DataFetchingEnvironment env,
        @GraphQLField(defaultValue = "0")
            int offset,
        @GraphQLField(defaultValue = "100")
            int limit
    )
    {
        final Map<String, GraphQLFieldDefinition> defs = env.getSelectionSet().getDefinitions();
        log.info("DEFS: {}", defs);

        final List<Foo> foos = dslContext.select()
            .from(FOO)
            .orderBy(FOO.NAME)
            .offset(offset)
            .limit(limit)
            .fetchInto(
                Foo.class
            );
        int count =
            dslContext.selectCount()
            .from(FOO)
            .fetchOne(DSL.count());
        
        return new PagedFoos(count, foos);
    }

    @GraphQLQuery
    public Foo fooDetail(
        DataFetchingEnvironment env,
        String id
    )
    {
        return dslContext.select()
            .from(FOO)
            .where(FOO.ID.eq(id))
            .fetchSingleInto(
                Foo.class
            );
    }


    @GraphQLMutation
    @PreAuthorize("hasRole('ROLE_USER')")
    public boolean storeFoo(Foo foo)
    {
        final String id = foo.getId();
        if (id == null)
        {
            final String newId = UUID.randomUUID().toString();
            foo.setId(newId);
            final FooRecord record = dslContext.newRecord(FOO, foo);
            dslContext.executeInsert(record);
        }
        else
        {
            final FooRecord record = dslContext.newRecord(FOO, foo);
            dslContext.executeUpdate(record);
        }
        return true;
    }


    @GraphQLQuery
    public List<AppUser> listUsers(
        DataFetchingEnvironment env,
        @GraphQLField(defaultValue = "0")
            int offset,
        @GraphQLField(defaultValue = "100")
            int limit
    )
    {
        final Map<String, GraphQLFieldDefinition> defs = env.getSelectionSet().getDefinitions();
        log.info("DEFS: {}", defs);

        return dslContext.select()
            .from(APP_USER)
            .orderBy(APP_USER.LOGIN)
            .offset(offset)
            .limit(limit)
            .fetchInto(
                AppUser.class
            );
    }
}
