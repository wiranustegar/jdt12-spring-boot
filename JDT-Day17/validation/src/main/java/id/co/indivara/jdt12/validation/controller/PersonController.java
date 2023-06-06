package id.co.indivara.jdt12.validation.controller;

import id.co.indivara.jdt12.validation.entity.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PersonController {

    @PostMapping("/contohvalidasi")
    public Person createPerson(@RequestBody @Valid Person person){
        Person p = person;
        p.setKeterangan("Data anda valid!");

        return p;
    }
}
