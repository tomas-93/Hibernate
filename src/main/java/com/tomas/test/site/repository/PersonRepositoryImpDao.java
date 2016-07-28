package com.tomas.test.site.repository;

import com.tomas.test.site.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 27/07/2016.
 */
@Repository
public class PersonRepositoryImpDao implements PersonRepositoryDao
{
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(Person p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
    }

    @Override
    public void updatePerson(Person p)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        return personsList;
    }

    @Override
    public Person getPersonById(Long id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, id);
        return p;
    }

    @Override
    public void removePerson(Long id)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, id);
        if(null != p){
            session.delete(p);
        }
    }
}
