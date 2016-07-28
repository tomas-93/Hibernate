package com.tomas.test.site.services;

import com.tomas.test.site.entity.Person;
import com.tomas.test.site.repository.PersonRepositoryDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 27/07/2016.
 */
@Service
public class PersonServicesImpDao implements PersonServicesDao
{
    @Inject
    private PersonRepositoryDao personRepositoryDao;

    @Override
    @Transactional
    public void addPerson(Person p)
    {
        personRepositoryDao.addPerson(p);
    }

    @Override
    @Transactional
    public void updatePerson(Person p)
    {
        personRepositoryDao.updatePerson(p);
    }

    @Override
    @Transactional
    public List<Person> listPersons()
    {
        return personRepositoryDao.listPersons();
    }

    @Override
    @Transactional
    public Person getPersonById(long id)
    {
        return personRepositoryDao.getPersonById(id);
    }

    @Override
    @Transactional
    public void removePerson(long id)
    {
        personRepositoryDao.removePerson(id);
    }
}
