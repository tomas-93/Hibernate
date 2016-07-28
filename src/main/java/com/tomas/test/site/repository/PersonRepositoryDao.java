package com.tomas.test.site.repository;

import com.tomas.test.site.entity.Person;

import java.util.List;

/**
 * Created by Tomas on 27/07/2016.
 */
public interface PersonRepositoryDao
{
     void addPerson(Person p);
     void updatePerson(Person p);
     List<Person> listPersons();
     Person getPersonById(Long id);
     void removePerson(Long id);
}
