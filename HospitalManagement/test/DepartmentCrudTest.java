/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Department;
import hospital.services.crud.DepartmentCrudService;
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
    private static long id;    
    private static ApplicationContext ctx;
    
    public DepartmentCrudTest(){
    }
    
    @Test(priority = 1)
    public void testDepartmentCreate(){
        System.out.println("---TESTDEPARTMENTCREATE---");
        Department department;
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("name", "ICU");
        stringValues.put("description", "Intensive Care Unit");
        stringValues.put("email", "icu@examplehospital.co.za");
        stringValues.put("contactNumber", "0215586584");        
        
        department = AppFactory.getDepartment(stringValues, 1, 100, (long)1);
        
        //String Map -> name, description, email address,contact number
        
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