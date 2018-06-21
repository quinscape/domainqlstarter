/*
 * This file is generated by jOOQ.
*/
package de.quinscape.domainqlstarter.domain;


import de.quinscape.domainqlstarter.domain.tables.AppLogin;
import de.quinscape.domainqlstarter.domain.tables.AppUser;
import de.quinscape.domainqlstarter.domain.tables.Foo;
import de.quinscape.domainqlstarter.domain.tables.FooType;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>public</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PK_APP_LOGIN = Indexes0.PK_APP_LOGIN;
    public static final Index PK_APP_USER = Indexes0.PK_APP_USER;
    public static final Index UC_APP_USER_LOGIN = Indexes0.UC_APP_USER_LOGIN;
    public static final Index PK_FOO = Indexes0.PK_FOO;
    public static final Index PK_FOO_TYPE = Indexes0.PK_FOO_TYPE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PK_APP_LOGIN = Internal.createIndex("pk_app_login", AppLogin.APP_LOGIN, new OrderField[] { AppLogin.APP_LOGIN.SERIES }, true);
        public static Index PK_APP_USER = Internal.createIndex("pk_app_user", AppUser.APP_USER, new OrderField[] { AppUser.APP_USER.ID }, true);
        public static Index UC_APP_USER_LOGIN = Internal.createIndex("uc_app_user_login", AppUser.APP_USER, new OrderField[] { AppUser.APP_USER.LOGIN }, true);
        public static Index PK_FOO = Internal.createIndex("pk_foo", Foo.FOO, new OrderField[] { Foo.FOO.ID }, true);
        public static Index PK_FOO_TYPE = Internal.createIndex("pk_foo_type", FooType.FOO_TYPE, new OrderField[] { FooType.FOO_TYPE.ID }, true);
    }
}
