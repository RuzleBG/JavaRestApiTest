package com.soosy.skrt.service;

import java.util.List;
import com.soosy.skrt.entity.Departament;
import com.soosy.skrt.error.DepartamentExcpetion;

public interface DepartamentService {
    public Departament saveDepartament (Departament departament);

    public List<Departament> getDepartaments();

    public Departament getById(Long id) throws DepartamentExcpetion;

    public void deleteDepartamentById(Long id);

    public Departament updateDepartament(Departament departament, Long id);

    public List<Departament> fetchDepartamentByName(String departamentName);

    public Departament findDepartamentByname(String departament);
}
