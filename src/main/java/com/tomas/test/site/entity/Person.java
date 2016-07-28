package com.tomas.test.site.entity;

import org.hibernate.annotations.Type;
import org.hibernate.type.BigIntegerType;

import javax.persistence.*;

/**
 * Created by Tomas on 27/07/2016.
 */
@Entity
@Table(name = "person")
public class Person
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String  name;
    @Basic
    private String surname;
    @Basic
    private Integer age;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }
}
