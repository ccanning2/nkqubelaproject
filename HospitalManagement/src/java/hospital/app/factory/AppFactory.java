/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.app.factory;

import hospital.model.embeddables.Contact;
import hospital.model.embeddables.Demographic;
import hospital.model.embeddables.Name;
import hospital.model.entities.Department;
import hospital.model.entities.MedicalAid;
import hospital.model.entities.Patient;
import hospital.model.entities.Person;
import hospital.model.entities.Roles;
import hospital.model.entities.ShoeboxItem;
import hospital.model.entities.StaffMember;
import hospital.model.entities.Users;
import hospital.model.entities.Ward;
import hospital.model.md5.PasswordEncrypt;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Hospital Management
 */

public class AppFactory {
    
    public static ShoeboxItem getShoeboxItem(Map<String, String> stringValues, final BigDecimal estimatedPrice){
        ShoeboxItem shoeboxItem = new ShoeboxItem();
        
        shoeboxItem.setEstimatedPrice(estimatedPrice);
        shoeboxItem.setItemName(stringValues.get("itemName"));
        shoeboxItem.setItemDescription(stringValues.get("itemDescription"));
        shoeboxItem.setImageUrl(stringValues.get("imageUrl"));
        
        return shoeboxItem;
    }
    
    public static Department getDepartment(Map<String, String> stringValues, Integer floorNumber, Integer size, StaffMember personInCharge) 
    {
        Department department = new Department();
        Contact contact = new Contact();
        
        department.setDepartmentSize(size);
        department.setDescription(stringValues.get("description"));
        department.setFloorNumber(floorNumber);
        department.setPersonInCharge(personInCharge);
        department.setName(stringValues.get("name"));
        
        contact.setContactNumber(stringValues.get("contactNumber"));
        contact.setEmailAddress(stringValues.get("email"));
        
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
    
    public static Patient getPatient(Map<String, String> stringValues, Map<String, Long> longValues, Map<String, Date> dateValues, final Boolean hasMedicalAid, final Ward ward) 
    {
        Name name = new Name();
        Contact contact = new Contact();
        Patient patient = new Patient();
        Demographic demographic = new Demographic();
        MedicalAid medicalAid = new MedicalAid();
       
        name.setFirstName(stringValues.get("firstName"));
        name.setLastName(stringValues.get("lastName"));
        name.setMiddleName(stringValues.get("middleName"));
        name.setNickName(stringValues.get("nickName"));
        
        contact.setContactNumber(stringValues.get("contactNumber"));
        contact.setEmailAddress(stringValues.get("emailAddress"));
        
        demographic.setDateOfBirth(dateValues.get("dateOfBirth"));
        demographic.setGender(stringValues.get("gender"));
        demographic.setRace(stringValues.get("race"));
        demographic.setTitle(stringValues.get("title"));
        
        if(hasMedicalAid == true){
            medicalAid.setMedicalAidName(stringValues.get("medicalAidName"));
            medicalAid.setMedicalAidScheme(stringValues.get("medicalAidScheme"));
            medicalAid.setMedicalAidNumber(longValues.get("medicalAidNumber"));
         }
        
        patient.setName(name);
        patient.setContact(contact);
        patient.setDemographic(demographic);
        patient.setPatientNumber(longValues.get("patientNumber"));
        patient.setBedNumber(longValues.get("bedNumber"));
        patient.setReasonForStay(stringValues.get("reasonForStay"));
        patient.setIdentityNumber(stringValues.get("identityNumber"));
        patient.setEstimatedDateOfDischarge(dateValues.get("estimatedDateOfDischarge"));
        patient.setDateOfArrival(dateValues.get("dateOfArrival"));
        patient.setCurrentCondition(stringValues.get("currentCondition"));
        
        patient.setWard(ward);
      
        return patient;
    }
    
    public static StaffMember getStaffMember(Map<String, String> stringValues, final String staffNumber, Date dateOfBirth) 
    {
        Name name = new Name();
        Contact contact = new Contact();
        StaffMember staffMember = new StaffMember();
        Demographic demographic = new Demographic();
       
        name.setFirstName(stringValues.get("firstName"));
        name.setLastName(stringValues.get("lastName"));
        name.setMiddleName(stringValues.get("middleName"));
        name.setNickName(stringValues.get("nickName"));
        
        contact.setContactNumber(stringValues.get("contactNumber"));
        contact.setEmailAddress(stringValues.get("emailAddress"));
        
        demographic.setDateOfBirth(dateOfBirth);
        demographic.setGender(stringValues.get("gender"));
        demographic.setRace(stringValues.get("race"));
        demographic.setTitle(stringValues.get("title"));

        staffMember.setName(name);
        staffMember.setContact(contact);
        staffMember.setDemographic(demographic);
        staffMember.setStaffNumber(staffNumber);
      
        return staffMember;
    }
     
    public static Ward getWard(Map<String, String> stringValues, Integer floorNumber, long wardNumber, Person personInCharge, Department department) 
    {
        Ward ward = new Ward();
        Contact contact = new Contact();
        
        contact.setContactNumber(stringValues.get("contactNumber"));
        contact.setEmailAddress(stringValues.get("emailAddress"));

        ward.setName(stringValues.get("name"));
        ward.setContact(contact);
        ward.setWardNumber(wardNumber);
        ward.setFloorNumber(floorNumber);
        ward.setPersonInCharge(personInCharge);
        ward.setVisitingHoursStart(stringValues.get("visitingHoursStart"));
        ward.setVisitingHoursEnd(stringValues.get("visitingHoursEnd"));
        ward.setDepartment(department);
        
        return ward;
    }
}
