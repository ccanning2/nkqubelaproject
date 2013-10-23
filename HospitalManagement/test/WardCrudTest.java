/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Person;
import hospital.model.entities.StaffMember;
import hospital.model.entities.Ward;
import hospital.services.crud.StaffMemberCrudService;
import hospital.services.crud.WardCrudService;
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
    private static long id;    
    private static ApplicationContext ctx;
    
    public WardCrudTest(){
    }
    
    @Test(priority = 1)
    public void testWardCreate(){
        System.out.println("---TESTWARDCREATE---");
        Ward ward;
        StaffMember staffMember = new StaffMember();
        
        staffMemberCrudService.persist(staffMember);
        
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("name", "WardOne");
        stringValues.put("person incharge", "Mary");
        stringValues.put("email", "icu@hospital.co.za");
        stringValues.put("contactNumber", "0878006584");        
        
        ward = AppFactory.getWard(stringValues, 1, 100, staffMember);
        
        wardCrudService.persist(ward);
        
        id = ward.getId();
        
        System.out.println("testWardCreate: id = " + id);
    }
    
    @Test(priority = 2)
    public void testWardRead(){        
        System.out.println("---TESTWARD---");
        Ward ward = wardCrudService.findById(id);

        System.out.println("Patients: " + ward.getPatients());
        System.out.println("Floor Number: " + ward.getFloorNumber());
        System.out.println("Person in charge: " + ward.getPersonInCharge());
        System.out.println("Ward Number: " + ward.getWardNumber());        
        

        Assert.assertEquals(ward.getPatients(), "ICU");
    }
    
    @Test(priority = 3)
    public void testWardUpdate(){
        System.out.println("---TESTWARD---");
        Ward ward = wardCrudService.findById(id);
        StaffMember staffMember = new StaffMember();
        
        staffMemberCrudService.persist(staffMember);
        
        ward.setWardNumber(250);
        ward.setPersonInCharge(staffMember);
        
        wardCrudService.merge(ward);
        
        Assert.assertEquals(ward.getPersonInCharge(), "Mary");
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


