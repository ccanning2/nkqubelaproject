/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.app.factory;

import hospital.model.entities.Department;
import hospital.model.entities.Roles;
import hospital.model.entities.Users;
import hospital.model.md5.PasswordEncrypt;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public static Users getUser(String userName, String passWord) throws NoSuchAlgorithmException
    {
        Users user = new Users();

        user.setPassWord(PasswordEncrypt.encrypt(passWord));
        user.setUserName(userName);
        
        return user;
    }
    
     public static Roles getRoles(String roleName, String description, String userName)
    {
        Roles role = new Roles();
        
        role.setDescription(description);
        role.setRoleName(roleName);
        role.setUserName(userName);
        
        return role;
    }
}
