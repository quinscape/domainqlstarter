/*
 * This file is generated by jOOQ.
*/
package de.quinscape.domainqlstarter.domain.tables.records;


import de.quinscape.domainqlstarter.domain.tables.Foo;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


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
@Entity
@Table(name = "foo", schema = "public", indexes = {
    @Index(name = "pk_foo", unique = true, columnList = "id ASC")
})
public class FooRecord extends UpdatableRecordImpl<FooRecord> implements Record7<String, String, Integer, Integer, Timestamp, String, String> {

    private static final long serialVersionUID = -1580835160;

    /**
     * Setter for <code>public.foo.id</code>.
     */
    public void setId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.foo.id</code>.
     */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @NotNull
    @Size(max = 36)
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.foo.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.foo.name</code>.
     */
    @Column(name = "name", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.foo.num</code>.
     */
    public void setNum(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.foo.num</code>.
     */
    @Column(name = "num", nullable = false, precision = 32)
    @NotNull
    public Integer getNum() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>public.foo.type_id</code>.
     */
    public void setTypeId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.foo.type_id</code>.
     */
    @Column(name = "type_id", nullable = false, precision = 32)
    @NotNull
    public Integer getTypeId() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>public.foo.created</code>.
     */
    public void setCreated(Timestamp value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.foo.created</code>.
     */
    @Column(name = "created", nullable = false)
    @NotNull
    public Timestamp getCreated() {
        return (Timestamp) get(4);
    }

    /**
     * Setter for <code>public.foo.description</code>.
     */
    public void setDescription(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.foo.description</code>.
     */
    @Column(name = "description")
    public String getDescription() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.foo.owner_id</code>.
     */
    public void setOwnerId(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.foo.owner_id</code>.
     */
    @Column(name = "owner_id", nullable = false, length = 36)
    @NotNull
    @Size(max = 36)
    public String getOwnerId() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, String, Integer, Integer, Timestamp, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<String, String, Integer, Integer, Timestamp, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return Foo.FOO.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return Foo.FOO.NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Foo.FOO.NUM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field4() {
        return Foo.FOO.TYPE_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field5() {
        return Foo.FOO.CREATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field6() {
        return Foo.FOO.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Foo.FOO.OWNER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component4() {
        return getTypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component5() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getOwnerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getNum();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value4() {
        return getTypeId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value5() {
        return getCreated();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value6() {
        return getDescription();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getOwnerId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value1(String value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value2(String value) {
        setName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value3(Integer value) {
        setNum(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value4(Integer value) {
        setTypeId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value5(Timestamp value) {
        setCreated(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value6(String value) {
        setDescription(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord value7(String value) {
        setOwnerId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FooRecord values(String value1, String value2, Integer value3, Integer value4, Timestamp value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FooRecord
     */
    public FooRecord() {
        super(Foo.FOO);
    }

    /**
     * Create a detached, initialised FooRecord
     */
    public FooRecord(String id, String name, Integer num, Integer typeId, Timestamp created, String description, String ownerId) {
        super(Foo.FOO);

        set(0, id);
        set(1, name);
        set(2, num);
        set(3, typeId);
        set(4, created);
        set(5, description);
        set(6, ownerId);
    }
}
