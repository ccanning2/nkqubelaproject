import hospital.model.entities.ShoeboxItem;
import hospital.services.crud.ShoeboxItemCrudService;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

public class ShoeboxItemCrudTest {
    
    private static ShoeboxItemCrudService shoeboxItemCrudService;
    private static long id;    
    private static ApplicationContext ctx;
    
    public ShoeboxItemCrudTest(){
    }
    
    @Test(priority = 1)
    public void testShoeboxItemCreate(){
        ShoeboxItem shoeboxItem = new ShoeboxItem();
        shoeboxItem.setEstimatedPrice(BigDecimal.valueOf(100));
        shoeboxItem.setImageUrl("fakeURL.jpg");
        shoeboxItem.setItemDescription("Tooth Brush made by Oral B");
        shoeboxItem.setItemName("Tooth Brush");
                
        shoeboxItemCrudService.persist(shoeboxItem);
    }
//    
//    @Test(priority = 2)
//    public void testDepartmentRead(){        
//        System.out.println("---TESTDEPARTMENTREAD---");
//        Department department = departmentCrudService.findById(id);
//
//        System.out.println("DepartmentSize: " + department.getDepartmentSize());
//        System.out.println("Description: " + department.getDescription());
//        System.out.println("FloorNumber: " + department.getFloorNumber());
//        System.out.println("Name: " + department.getName());
//        
//        Assert.assertEquals(department.getName(), "ICU");
//    }
//    
//    @Test(priority = 3)
//    public void testDepartmentUpdate(){
//        System.out.println("---TESTDEPARTMENTUPDATE---");
//        Department department = departmentCrudService.findById(id);
//        
//        department.setDepartmentSize(250);
//        department.setDescription("Intensive Care Unit/Ward");
//        
//        departmentCrudService.merge(department);
//        
//        Assert.assertEquals(department.getDescription(), "Intensive Care Unit/Ward");
//    }
//    
//    @Test(enabled = false, priority = 4)
//    public void testDepartmentDelete(){
//        System.out.println("---TESTDEPARTMENTDELETE---");
//        
//        departmentCrudService.remove(departmentCrudService.findById(id));
//        
//        Assert.assertNull(departmentCrudService.findById(id));
//    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-connection.xml");
        shoeboxItemCrudService = (ShoeboxItemCrudService) ctx.getBean("shoeboxItemCrudService");
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