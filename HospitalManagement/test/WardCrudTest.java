/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Department;
import hospital.model.entities.Person;
import hospital.model.entities.StaffMember;
import hospital.model.entities.Ward;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.StaffMemberCrudService;
import hospital.services.crud.WardCrudService;
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

public class WardCrudTest {
    
    private static WardCrudService wardCrudService;
    private static StaffMemberCrudService staffMemberCrudService;
    private static DepartmentCrudService departmentCrudService;
    private static long id;    
    private static ApplicationContext ctx;
    
    public WardCrudTest(){
    }
    
    @Test(priority = 1)
    public void testWardCreate(){
        System.out.println("---TESTWARDCREATE---");
        Ward ward;
        StaffMember staffMember;
        Department department;
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("firstName", "James");
        stringValues.put("lastName", "Smith");
        stringValues.put("middleName", "John");
        stringValues.put("nickName", "Johnny");
        stringValues.put("contactNumber", "0215577845");
        stringValues.put("emailAddress", "john@examplehospital.co.za");
        stringValues.put("gender", "Male");
        stringValues.put("race", "White");
        stringValues.put("title", "Mr");
        stringValues.put("identityNumber", "8595625214855");     
        
        staffMember = AppFactory.getStaffMember(stringValues, "8859855", new Date());

        Map<String, String> stringValues2 = new HashMap<String, String>();

        stringValues2.put("name", "A1");
        stringValues2.put("description", "Children's Ward");
        stringValues2.put("email", "a1children@examplehospital.co.za");
        stringValues2.put("contactNumber", "0215589652"); 
        
        staffMemberCrudService.persist(staffMember);
        
        department = AppFactory.getDepartment(stringValues2, 1, 285, staffMember);

        departmentCrudService.persist(department);
        
        Map<String, String> stringValues3 = new HashMap<String, String>();
        
        stringValues3.put("name", "Maternity Department");
        stringValues3.put("visitingHoursStart", "18:00");
        stringValues3.put("visitingHoursEnd", "19:00");
        stringValues3.put("emailAddress", "maternity@examplehospital.co.za");
        stringValues3.put("contactNumber", "0215576254");             
        
        ward = AppFactory.getWard(stringValues3, 1, 100, staffMember, department);
        
        wardCrudService.persist(ward);
        
        id = ward.getId();
    }
    
    @Test(priority = 2)
    public void testWardRead(){        
        System.out.println("---TESTWARD---");
        Ward ward = wardCrudService.findById(id);
        
        System.out.println("Floor Number: " + ward.getFloorNumber());
        System.out.println("Person in charge: " + ward.getPersonInCharge());
        System.out.println("Ward Number: " + ward.getWardNumber());        

        Assert.assertEquals(ward.getName(), "Maternity Department");
    }
    
    @Test(priority = 3)
    public void testWardUpdate(){
        System.out.println("---TESTWARD---");
        Ward ward = wardCrudService.findById(id);
        
        ward.setWardNumber(250);
        ward.setFloorNumber(3);
        
        wardCrudService.merge(ward);
        
        Assert.assertEquals(ward.getWardNumber(), 250);
    }
    
    @Test(enabled = false, priority = 4)
    public void testWardDelete(){
        System.out.println("---TESTWARD---");
        
        wardCrudService.remove(wardCrudService.findById(id));
        
        Assert.assertNull(wardCrudService.findById(id));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-connection.xml");
        wardCrudService = (WardCrudService) ctx.getBean("wardCrudService");
        staffMemberCrudService = (StaffMemberCrudService) ctx.getBean("staffMemberCrudService");
        departmentCrudService = (DepartmentCrudService) ctx.getBean("departmentCrudService");
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


