package com.soosy.skrt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soosy.skrt.entity.Departament;
import com.soosy.skrt.error.DepartamentExcpetion;
import com.soosy.skrt.repository.DepartamentRepository;

@Service
public class DepartamentServiceImpl implements DepartamentService {

    @Autowired
    private DepartamentRepository departamentRepository;

    public String joe="";
    public String getJoe() {
        return joe;
    }

    @Override
    public Departament saveDepartament(Departament departament) {
        return departamentRepository.save(departament); 
    }

    @Override
    public List<Departament> getDepartaments() {
        return departamentRepository.findAll();
    }

    @Override
    public Departament getById(Long id) throws DepartamentExcpetion {
        Optional<Departament> departament= departamentRepository.findById(id);
        if(departament.isPresent()){
            return departament.get();
        }
        else{
            throw new DepartamentExcpetion("No such departament id");
        }
    }

    @Override
    public void deleteDepartamentById(Long id) {
        departamentRepository.deleteById(id);
    }

    @Override
    public Departament updateDepartament(Departament departament, Long id) {
        Departament debDb=departamentRepository.findById(id).get();
        debDb.setDepartamentAddress(departament.getDepartamentAddress());
        debDb.setDepartamentCode(departament.getDepartamentCode());
        debDb.setDepartamentName(departament.getDepartamentName());
        departamentRepository.save(debDb);
        return debDb;
    }

    @Override
    public List<Departament> fetchDepartamentByName(String departamentName) {
        //return departamentRepository.findbyDepartamentName(departamentName);
        
        List<Departament> foundNames=departamentRepository.findAll()
                                                            .stream()
                                                            .filter(departament->departament.getDepartamentName().equals(departamentName))
                                                            .collect(Collectors.toList());
        return foundNames;
    }

    @Override
    public Departament findDepartamentByname(String departamentName) {
        return departamentRepository.findByDepartmentName(departamentName);
    }
    
    
}
