package com.soosy.skrt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Departament {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departamentId;

    @NotBlank(message = "Input departament name")
    private String departamentName;
    private String departamentAddress;
    private String departamentCode;

    @Override
    public String toString() {
        return departamentId+" "+ departamentName+" "+departamentAddress+" "+departamentCode;
    }
    
}
