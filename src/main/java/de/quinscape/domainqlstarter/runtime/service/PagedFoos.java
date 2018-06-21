package de.quinscape.domainqlstarter.runtime.service;

import de.quinscape.domainqlstarter.domain.tables.pojos.Foo;
import org.svenson.JSONTypeHint;

import java.util.List;

public class PagedFoos
{
    private final int rowCount;
    private final List<Foo> foos;


    public PagedFoos(int rowCount, List<Foo> foos)
    {
        this.rowCount = rowCount;
        this.foos = foos;
    }


    public int getRowCount()
    {
        return rowCount;
    }

    @JSONTypeHint(Foo.class)
    public List<Foo> getFoos()
    {
        return foos;
    }
}
