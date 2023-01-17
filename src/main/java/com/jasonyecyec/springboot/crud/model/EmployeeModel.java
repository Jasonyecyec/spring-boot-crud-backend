package com.jasonyecyec.springboot.crud.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class EmployeeModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

}
