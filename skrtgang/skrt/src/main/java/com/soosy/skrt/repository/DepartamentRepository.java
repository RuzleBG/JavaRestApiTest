package com.soosy.skrt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.soosy.skrt.entity.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {
    @Query(value = "SELECT * FROM DEPARTAMENT WHERE DEPARTAMENT_NAME=?1", nativeQuery = true)
    public Departament findByDepartmentName(String departamentName);
}
