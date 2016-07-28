package com.tomas.test.site.controller;

import com.tomas.test.site.entity.Person;
import com.tomas.test.site.services.PersonServicesDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Tomas on 27/07/2016.
 */
@Controller
public class PersonController
{
    @Inject
    private PersonServicesDao servicesDao;
    private Logger message = LogManager.getLogger();
    private String next="\n\n\n\n";

    @RequestMapping(value = {"/","event"})
    public String event(Model model)
    {
        List<Person> personList = this.servicesDao.listPersons();
        message.info(next);
        personList.stream().map(Person::getId).forEach(System.out::println);
        message.info(next);
        model.addAttribute("personList",personList);
        return "even/even";
    }
    @RequestMapping(value = "/add")
    public String add()
    {
        Person person = new Person();
        person.setName("Yussef");
        person.setSurname("Galicia");
        person.setAge(23);
        this.servicesDao.addPerson(person);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id)
    {
        this.servicesDao.removePerson(id);
        return "redirect:/";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable long id)
    {
        Person person = this.servicesDao.getPersonById(id);
        person.setName("Tomas Yussef Galicia");
        this.servicesDao.updatePerson(person);
        return "redirect:/";
    }
}
