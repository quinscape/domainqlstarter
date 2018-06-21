package de.quinscape.domainqlstarter.runtime.config;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration
    extends WebSecurityConfigurerAdapter
{

    private final DSLContext dslContext;

    private final static String[] PUBLIC_URIS = new String[]
        {
            "/index.jsp",
            "/error",
            "/js/**",
            "/graphql",
            "/css/**",
            "/webfonts/**",
            "/"
        };


    @Autowired
    public SecurityConfiguration(DSLContext dslContext)
    {
        this.dslContext = dslContext;
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
                    .defaultSuccessUrl("/app/exceed")
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

        web.ignoring()
            .antMatchers(PUBLIC_URIS)
            //.and().debug(true)
            ;
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
