/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.app.factory;

import hospital.model.entities.Department;

/**
 *
 * @author Hospital Management
 */

public class AppFactory 
{
    public static Department getDepartment(String name, Integer floorNumber, String description, Integer size, Long personInCharge) 
    {
        Department department = new Department();
        
        department.setDepartmentSize(size);
        department.setDescription(description);
        department.setFloorNumber(floorNumber);
        department.setPersonInCharge(personInCharge);
        department.setName(name);
        
        return department;
    }
}
