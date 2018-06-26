package de.quinscape.domainqlstarter.runtime.config;

import de.quinscape.domainqlstarter.runtime.controller.GraphQLController;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;

public class AllowDevGraphQLAccess
    implements RequestMatcher
{
    private final boolean allowDevGraphQLAccess;


    public AllowDevGraphQLAccess(boolean allowDevGraphQLAccess)
    {
        this.allowDevGraphQLAccess = allowDevGraphQLAccess;
    }


    @Override
    public boolean matches(HttpServletRequest request)
    {
        // we only protect POST requests
        if (!request.getMethod().equals("POST"))
        {
            return false;
        }

        // require all requests to be requested unless allowDevGraphQLAccess is set and the request is to the special dev graphql URI
        return
            !(
                allowDevGraphQLAccess &&
                request.getRequestURI().equals(request.getContextPath() + GraphQLController.GRAPHQL_DEV_URI)
            );
    }
}
