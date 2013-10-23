/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.embeddables.Demographic;
import hospital.model.embeddables.Name;
import hospital.model.entities.Department;
import hospital.model.entities.Person;
import hospital.model.entities.StaffMember;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.PersonCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Hospital Management
 */

public class DepartmentCrudTest {
    
    private static DepartmentCrudService departmentCrudService;
    private static PersonCrudService personCrudService;
    private static long id;    
    private static ApplicationContext ctx;
    
    public DepartmentCrudTest(){
    }
    
    @Test(priority = 1)
    public void testDepartmentCreate(){
        System.out.println("---TESTDEPARTMENTCREATE---");
        Department department;
        
        /* TODO: Once Enzo has completed StaffMember & Patient services -> move to app factory */
        StaffMember staffMember = new StaffMember();
        Name name = new Name();
        Contact contact = new Contact();
        Demographic demographic = new Demographic();
        
        name.setFirstName("Christopher");
        name.setLastName("Canning");
        name.setNickName("Chris");
        
        contact.setContactNumber("0215577865");
        contact.setEmailAddress("chris@hospital.co.za");
        
        demographic.setDateOfBirth(new Date());
        demographic.setGender("Male");
        demographic.setRace("White");
        demographic.setTitle("Mr");
        
        staffMember.setEndTime("08:00");
        staffMember.setField("Nurse");
        staffMember.setIdentityNumber("911225104080");
        staffMember.setStaffNumber("15586655844");
        staffMember.setStartTime("16:00");
        staffMember.setType("Level 3");        
        
        staffMember.setDemographic(demographic);        
        staffMember.setContact(contact);
        staffMember.setName(name);
        
        personCrudService.persist(staffMember);
        
        staffMember = (StaffMember)personCrudService.findById(staffMember.getId());
        
        System.out.println("STAFF MEMBER ID: " + staffMember.getId());
        System.out.println("NAME: " + staffMember.getName().getFirstName() + " | " + staffMember.getName().getLastName());
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("name", "ICU");
        stringValues.put("description", "Intensive Care Unit");
        stringValues.put("email", "icu@examplehospital.co.za");
        stringValues.put("contactNumber", "0215586584");        
        
        department = AppFactory.getDepartment(stringValues, 1, 100, staffMember);
        
        departmentCrudService.persist(department);
        
        id = department.getId();
        
        System.out.println("testDepartmentCreate: id = " + id);
    }
    
    @Test(priority = 2)
    public void testDepartmentRead(){        
        System.out.println("---TESTDEPARTMENTREAD---");
        Department department = departmentCrudService.findById(id);

        System.out.println("DepartmentSize: " + department.getDepartmentSize());
        System.out.println("Description: " + department.getDescription());
        System.out.println("FloorNumber: " + department.getFloorNumber());
        System.out.println("Name: " + department.getName());
        
        Assert.assertEquals(department.getName(), "ICU");
    }
    
    @Test(priority = 3)
    public void testDepartmentUpdate(){
        System.out.println("---TESTDEPARTMENTUPDATE---");
        Department department = departmentCrudService.findById(id);
        
        department.setDepartmentSize(250);
        department.setDescription("Intensive Care Unit/Ward");
        
        departmentCrudService.merge(department);
        
        Assert.assertEquals(department.getDescription(), "Intensive Care Unit/Ward");
    }
    
    @Test(enabled = false, priority = 4)
    public void testDepartmentDelete(){
        System.out.println("---TESTDEPARTMENTDELETE---");
        
        departmentCrudService.remove(departmentCrudService.findById(id));
        
        Assert.assertNull(departmentCrudService.findById(id));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-connection.xml");
        departmentCrudService = (DepartmentCrudService) ctx.getBean("departmentCrudService");
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}