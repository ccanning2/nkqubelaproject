/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.app.factory;

import hospital.model.embeddables.Contact;
import hospital.model.entities.Department;
import hospital.model.entities.Roles;
import hospital.model.entities.Users;
import hospital.model.md5.PasswordEncrypt;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hospital Management
 */

public class AppFactory 
{
    public static Department getDepartment(Map<String, String> stringValues, Integer floorNumber, Integer size, Long personInCharge) 
    {
        Department department = new Department();
        Contact contact = new Contact();
        
        department.setDepartmentSize(size);
        department.setDescription(stringValues.get("description"));
        department.setFloorNumber(floorNumber);
        department.setPersonInCharge(personInCharge);
        department.setName(stringValues.get("name"));
        
        contact.setContactNumber(stringValues.get("contactNumber"));
        contact.setContactNumber(stringValues.get("email"));
        
        department.setContact(contact);
        
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
