/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Department;
import hospital.model.entities.Roles;
import hospital.model.entities.Users;
import hospital.model.md5.PasswordEncrypt;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.RolesCrudService;
import hospital.services.crud.UserCrudService;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
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
public class UserCrudTest {
    
    private UserCrudService userCrudService;
    private RolesCrudService rolesCrudService;
    
    private static ApplicationContext ctx;
    
    public UserCrudTest() {
    }
    
    @Test
    public void testDepartmentCrud() throws NoSuchAlgorithmException{
        userCrudService = (UserCrudService) ctx.getBean("userCrudService");
        rolesCrudService = (RolesCrudService) ctx.getBean("rolesCrudService");
        
        Users user1 = AppFactory.getUser("chris", "canning");
        Users user2 = AppFactory.getUser("kevin", "canning");
        Users user3 = AppFactory.getUser("gizelle", "heunis");
        Users user4 = AppFactory.getUser("enzo", "dejongh");

        user1.setEnabled(true);
        user2.setEnabled(true);
        user3.setEnabled(true);
        user4.setEnabled(true);
        
        List<Roles> roles1 = new ArrayList<Roles>();
        List<Roles> roles2 = new ArrayList<Roles>();
        List<Roles> roles3 = new ArrayList<Roles>();
        List<Roles> roles4 = new ArrayList<Roles>();
        
        Roles role1 = AppFactory.getRoles("General", "Administration rights allowed", "chris");
        Roles role2 = AppFactory.getRoles("General", "Administration rights allowed", "kevin");
        Roles role3 = AppFactory.getRoles("General", "Administration rights allowed", "gizelle");
        Roles role4 = AppFactory.getRoles("General", "Administration rights allowed", "enzo");
        
        roles1.add(role1);
        roles2.add(role2);                
        roles3.add(role3);
        roles4.add(role4);
        
        user1.setRoles(roles1);
        user2.setRoles(roles2);
        user3.setRoles(roles3);
        user4.setRoles(roles4);
        
        userCrudService.persist(user1);
        userCrudService.persist(user2);
        userCrudService.persist(user3);
        userCrudService.persist(user4);
                                
        rolesCrudService.persist(role1);
        rolesCrudService.persist(role2);        
        rolesCrudService.persist(role3);
        rolesCrudService.persist(role4);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-connection.xml");
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