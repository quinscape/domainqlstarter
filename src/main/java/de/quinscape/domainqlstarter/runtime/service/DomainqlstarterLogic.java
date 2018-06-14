package de.quinscape.domainqlstarter.runtime.service;

import de.quinscape.domainql.annotation.GraphQLField;
import de.quinscape.domainql.annotation.GraphQLLogic;
import de.quinscape.domainql.annotation.GraphQLMutation;
import de.quinscape.domainql.annotation.GraphQLQuery;
import de.quinscape.domainqlstarter.domain.tables.pojos.AppUser;
import de.quinscape.domainqlstarter.domain.tables.pojos.Foo;
import de.quinscape.domainqlstarter.domain.tables.records.FooRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

import static de.quinscape.domainqlstarter.domain.Tables.*;

@GraphQLLogic
public class DomainqlstarterLogic
{
    private final DSLContext dslContext;


    @Autowired
    public DomainqlstarterLogic(DSLContext dslContext)
    {
        this.dslContext = dslContext;
    }


    @GraphQLQuery
    public List<Foo> foos(
        String id,
        @GraphQLField(defaultValue = "0")
            int offset,
        @GraphQLField(defaultValue = "100")
            int limit
    )
    {
        return dslContext.select()
            .from(FOO)
            .where(id != null ? FOO.ID.eq(id) : null)
            .limit(limit)
            .offset(offset)
            .fetchInto(
                Foo.class
            );
    }


    @GraphQLQuery
    public List<AppUser> users(
        String id,
        @GraphQLField(defaultValue = "0")
            int offset,
        @GraphQLField(defaultValue = "100")
            int limit
    )
    {
        return dslContext.select()
            .from(APP_USER)
            .where(id != null ? APP_USER.ID.eq(id) : null)
            .limit(limit)
            .offset(offset)
            .fetchInto(
                AppUser.class
            );
    }

    @GraphQLMutation
    public Foo storeFoo(Foo foo)
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
        return foo;
    }

}
