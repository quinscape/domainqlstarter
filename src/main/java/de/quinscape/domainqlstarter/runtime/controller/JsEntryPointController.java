package de.quinscape.domainqlstarter.runtime.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JsEntryPointController
{
    @RequestMapping("/app/**")
    public String serveApplicationEndpoint()
    {
        return "main";
    }

    @RequestMapping("/admin/**")
    public String serveAdminApplicationEndpoint()
    {
        return "admin";
    }

    @RequestMapping("/login")
    public String serveLogin()
    {
        return "login";
    }
}
