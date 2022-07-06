package com.soosy.skrt.error;

public class DepartamentExcpetion extends Exception{
    public DepartamentExcpetion(String message){
        super(message);
    }
    public DepartamentExcpetion(String message, Throwable cause){
        super(message, cause);
    }
}
