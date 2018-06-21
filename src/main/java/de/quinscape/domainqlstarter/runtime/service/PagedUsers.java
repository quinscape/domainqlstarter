package de.quinscape.domainqlstarter.runtime.service;

import de.quinscape.domainqlstarter.domain.tables.pojos.AppUser;

import java.util.List;

public class PagedUsers
{
    private final int rowCount;
    private final List<AppUser> appUsers;


    public PagedUsers(int rowCount, List<AppUser> appUsers)
    {
        this.rowCount = rowCount;
        this.appUsers = appUsers;
    }


    public List<AppUser> getAppUsers()
    {
        return appUsers;
    }

    public int getRowCount()
    {
        return rowCount;
    }


}
