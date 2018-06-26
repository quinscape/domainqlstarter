package de.quinscape.domainqlstarter.runtime.config;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


// Enable method security ( with @PreAuthorize/@PostAuthorize annotations)
@EnableGlobalMethodSecurity(prePostEnabled = true)

@EnableWebSecurity
@Configuration
@Import(MethodSecurityConfiguration.class)
public class SecurityConfiguration
    extends WebSecurityConfigurerAdapter
{

    private final DSLContext dslContext;

    private final boolean ignoreGraphQLEndpoint;

    private static String GRAPHQL_URI = "/graphql";

    private final static String[] PUBLIC_URIS = new String[]
        {
            "/index.jsp",
            "/error",
            "/js/**",
            GRAPHQL_URI,
            "/css/**",
            "/webfonts/**",
            "/"
        };


    @Autowired
    public SecurityConfiguration(
        DSLContext dslContext,
        @Value("${domainql.allow-external-graphql:false}")
        boolean ignoreGraphQLEndpoint)
    {
        this.dslContext = dslContext;
        this.ignoreGraphQLEndpoint = ignoreGraphQLEndpoint;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
            .antMatchers(
                PUBLIC_URIS
            ).permitAll()

            // TODO: consider protected routes
            .antMatchers("/admin/**")
                .hasRole("ADMIN")

            .and()
                .formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login_check")
                    .defaultSuccessUrl("/app/")
                    .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("remember-me")
                .and()
                .rememberMe()
                    // TODO: create your own (random) secret
                    .key("vbi9Q.&siS-domainqlstarter")
                    .tokenRepository(persistentTokenRepository())
                    .userDetailsService(userDetailsServiceBean());

    }


    @Override
    public void configure(WebSecurity web) throws Exception
    {
        if (ignoreGraphQLEndpoint)
        {
            web.ignoring().antMatchers(GRAPHQL_URI);
        }
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth
            .userDetailsService(userDetailsServiceBean())
            .passwordEncoder(new BCryptPasswordEncoder());

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository()
    {
        return new DefaultPersistentTokenRepository(dslContext);
    }


    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean()
    {
        return new AppAuthenticationService(
            dslContext
        );
    }
}
