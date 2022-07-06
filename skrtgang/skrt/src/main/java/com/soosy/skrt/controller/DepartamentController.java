package com.soosy.skrt.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soosy.skrt.entity.Departament;
import com.soosy.skrt.error.DepartamentExcpetion;
import com.soosy.skrt.service.DepartamentService;

@RestController
public class DepartamentController{
    @Autowired
    private DepartamentService departamentService;
    private final org.jboss.logging.Logger logger=LoggerFactory.logger(DepartamentController.class);

    @PostMapping("/departaments")
    public Departament saveDepartament(@Valid @RequestBody Departament departament){
        logger.info("Inside save dapartament");
        return departamentService.saveDepartament(departament);
    }

    @GetMapping("/departaments")
    public List<Departament> getDepartaments(){
        logger.info("Inside get dapartament");
        return departamentService.getDepartaments();
    }

    @GetMapping("/departament/{id}")
    public Departament getDepartamentById(@PathVariable("id") Long id) throws DepartamentExcpetion{
        return departamentService.getById(id);
    }
    @DeleteMapping("/departament/{id}")
    public void deleteDepartamentById(@PathVariable("id") Long id){
        departamentService.deleteDepartamentById(id);
    }

    @PutMapping("/departament/{id}")
    public Departament updateDepartament(@RequestBody Departament departament, @PathVariable("id") Long id){
        return departamentService.updateDepartament(departament, id);
    }
    @GetMapping("/departament/name/{name}")
    public Departament fetchDepartamentByName(@PathVariable("name") String departamentName){
        return departamentService.findDepartamentByname(departamentName);
    } 
}