/*
 * This file is generated by jOOQ.
*/
package de.quinscape.domainqlstarter.domain.tables;


import de.quinscape.domainqlstarter.domain.Indexes;
import de.quinscape.domainqlstarter.domain.Keys;
import de.quinscape.domainqlstarter.domain.Public;
import de.quinscape.domainqlstarter.domain.tables.records.AppUserRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AppUser extends TableImpl<AppUserRecord> {

    private static final long serialVersionUID = 1884080971;

    /**
     * The reference instance of <code>public.app_user</code>
     */
    public static final AppUser APP_USER = new AppUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AppUserRecord> getRecordType() {
        return AppUserRecord.class;
    }

    /**
     * The column <code>public.app_user.id</code>.
     */
    public final TableField<AppUserRecord, String> ID = createField("id", org.jooq.impl.SQLDataType.VARCHAR(36).nullable(false), this, "");

    /**
     * The column <code>public.app_user.login</code>.
     */
    public final TableField<AppUserRecord, String> LOGIN = createField("login", org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>public.app_user.password</code>.
     */
    public final TableField<AppUserRecord, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.app_user.disabled</code>.
     */
    public final TableField<AppUserRecord, Boolean> DISABLED = createField("disabled", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

    /**
     * The column <code>public.app_user.created</code>.
     */
    public final TableField<AppUserRecord, Timestamp> CREATED = createField("created", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.app_user.last_login</code>.
     */
    public final TableField<AppUserRecord, Timestamp> LAST_LOGIN = createField("last_login", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.app_user.roles</code>.
     */
    public final TableField<AppUserRecord, String> ROLES = createField("roles", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>public.app_user</code> table reference
     */
    public AppUser() {
        this(DSL.name("app_user"), null);
    }

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    public AppUser(String alias) {
        this(DSL.name(alias), APP_USER);
    }

    /**
     * Create an aliased <code>public.app_user</code> table reference
     */
    public AppUser(Name alias) {
        this(alias, APP_USER);
    }

    private AppUser(Name alias, Table<AppUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private AppUser(Name alias, Table<AppUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PK_APP_USER, Indexes.UC_APP_USER_LOGIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AppUserRecord> getPrimaryKey() {
        return Keys.PK_APP_USER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AppUserRecord>> getKeys() {
        return Arrays.<UniqueKey<AppUserRecord>>asList(Keys.PK_APP_USER, Keys.UC_APP_USER_LOGIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser as(String alias) {
        return new AppUser(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AppUser as(Name alias) {
        return new AppUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AppUser rename(String name) {
        return new AppUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AppUser rename(Name name) {
        return new AppUser(name, null);
    }
}
