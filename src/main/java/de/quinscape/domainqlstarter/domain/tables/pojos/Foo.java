/*
 * This file is generated by jOOQ.
*/
package de.quinscape.domainqlstarter.domain.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


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
public class Foo implements Serializable {

    private static final long serialVersionUID = 1784662697;

    private String    id;
    private String    name;
    private Integer   num;
    private Integer   typeId;
    private Timestamp created;
    private String    description;
    private String    ownerId;

    public Foo() {}

    public Foo(Foo value) {
        this.id = value.id;
        this.name = value.name;
        this.num = value.num;
        this.typeId = value.typeId;
        this.created = value.created;
        this.description = value.description;
        this.ownerId = value.ownerId;
    }

    public Foo(
        String    id,
        String    name,
        Integer   num,
        Integer   typeId,
        Timestamp created,
        String    description,
        String    ownerId
    ) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.typeId = typeId;
        this.created = created;
        this.description = description;
        this.ownerId = ownerId;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, length = 36)
    @NotNull
    @Size(max = 36)
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 100)
    @NotNull
    @Size(max = 100)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "num", nullable = false, precision = 32)
    @NotNull
    public Integer getNum() {
        return this.num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Column(name = "type_id", nullable = false, precision = 32)
    @NotNull
    public Integer getTypeId() {
        return this.typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Column(name = "created", nullable = false)
    @NotNull
    public Timestamp getCreated() {
        return this.created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "owner_id", nullable = false, length = 36)
    @NotNull
    @Size(max = 36)
    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Foo (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(num);
        sb.append(", ").append(typeId);
        sb.append(", ").append(created);
        sb.append(", ").append(description);
        sb.append(", ").append(ownerId);

        sb.append(")");
        return sb.toString();
    }
}
