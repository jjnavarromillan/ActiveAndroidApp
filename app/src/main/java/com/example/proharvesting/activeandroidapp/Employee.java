package com.example.proharvesting.activeandroidapp;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by proharvesting on 11/25/2016.
 */

@Table(name="Employee")
public class Employee extends Model {
    @Column(name="employee_id")
    public int EmployeeID;
    @Column(name="first_name")
    public String FirstName;
    @Column(name="last_name")
    public String LastName;

    public static List<Employee> getAllEmployees(){
        return new Select().from(Employee.class).execute();
    }





}
