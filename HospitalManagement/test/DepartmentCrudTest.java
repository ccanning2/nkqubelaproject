/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Department;
import hospital.services.crud.DepartmentCrudService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
    
    private DepartmentCrudService departmentCrudService;
    
    private static ApplicationContext ctx;
    
    public DepartmentCrudTest() {
    }
    
    @Test
    public void testDepartmentCrud(){
        departmentCrudService = (DepartmentCrudService) ctx.getBean("departmentCrudService");
        Department department = AppFactory.getDepartment("Chris Canning", 1, "This is the description", 100, (long)1);

        System.out.println(department.getDepartmentSize());
        System.out.println(department.getDescription());
        System.out.println(department.getFloorNumber());
        System.out.println(department.getName());
        
        departmentCrudService.persist(department);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
         ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-*.xml");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}