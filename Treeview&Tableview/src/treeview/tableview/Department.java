/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treeview.tableview;

import java.util.ArrayList;

/**
 *
 * @author Jelle
 */
public class Department {
    
    private String name;
    private ArrayList<Employee> employees;
    
    public Department(String name)
    {
        this.name = name;
        employees = new ArrayList<>();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public ArrayList<Employee> getEmployees()
    {
        return this.employees;
    }
    
    public void addEmployee(Employee e)
    {
        employees.add(e);
    }
    
    @Override
    public String toString()
    {
        return this.name;
    }
    
}
