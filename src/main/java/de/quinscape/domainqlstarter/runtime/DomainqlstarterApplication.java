package de.quinscape.domainqlstarter.runtime;

import de.quinscape.domainqlstarter.runtime.config.DomainConfiguration;
import de.quinscape.domainqlstarter.runtime.config.GraphQLConfiguration;
import de.quinscape.domainqlstarter.runtime.config.SecurityConfiguration;
import de.quinscape.domainqlstarter.runtime.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class
})
@ComponentScan(
    basePackages = {
        "de.quinscape.domainqlstarter.runtime.controller",
        "de.quinscape.domainqlstarter.runtime.service"
    }
)
@Import({
    GraphQLConfiguration.class,
    DomainConfiguration.class,
    WebConfiguration.class,
    SecurityConfiguration.class
})
@PropertySource({"classpath:domainqlstarter-${stage:dev}.properties"})
// TODO: rename starter class
public class DomainqlstarterApplication
    extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(DomainqlstarterApplication.class);
    }


    public static void main(String[] args)
    {
        SpringApplication.run(DomainqlstarterApplication.class, args);
    }
}
