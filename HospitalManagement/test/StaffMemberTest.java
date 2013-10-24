/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.factory.AppFactory;
import hospital.model.entities.Patient;
import hospital.services.crud.PatientCrudService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Hospital Management
 */

public class StaffMemberTest {
    
    private static PatientCrudService patientCrudService;
    private static long id;    
    private static ApplicationContext ctx;
    
    public StaffMemberTest(){
    }
    
    @Test(priority = 1)
    @SuppressWarnings({"null", "ConstantConditions"})
    public void testPatientCreate(){
        System.out.println("---TESTPATIENTCREATE---");
        Patient patient = null;
        
        Map<String, String> stringValues = new HashMap<String, String>();
       
        stringValues.put("bedNumber", "1");
        stringValues.put("dateOfArrival", "24 JUNE 2013");
        stringValues.put("name", "enzo");
        stringValues.put("medicalAidId", "1");
        stringValues.put("patientNumber", "111");
        stringValues.put("reasonForStay", "CANCER");
        
       
        //patient = AppFactory.getPatient(stringValues,1,(long)111, new Date(), new Date(), false);
        
        //patientCrudService.persist(patient);
        
        //id = patient.getId();
        
        //System.out.println("testPatientCreate: id = " + id);
    }
    
    @Test(priority = 2)
    public void testPatientRead(){        
        System.out.println("---TESTPATIENTREAD---");
        Patient patient = patientCrudService.findById(id);

        System.out.println("id: " + patient.getId());
        System.out.println("bedNumber: " + patient.getBedNumber());
        System.out.println("dateOfArrival: " + patient.getDateOfArrival());
        System.out.println("name: " + patient.getFullName());
        System.out.println("dateOfArrival: " + patient.getDateOfArrival());
        System.out.println("medicalAidId: " + patient.getMedicalAid());
        System.out.println("patientNumber: " + patient.getPatientNumber());
        System.out.println("reasonForStay: " + patient.getReasonForStay());
        
        Assert.assertEquals(patient.getId(), "4");
    }
    
    @Test(priority = 3)
    public void testPatientUpdate(){
        System.out.println("---TESTPATIENTUPDATE---");
       Patient patient = patientCrudService.findById(id);
        
        patient.setCurrentCondition("CANCER");
        patient.getName().setFirstName("JOHN");
        
        patientCrudService.merge(patient);
        
        Assert.assertEquals(patient.getFullName(), "JOHN");
    }
    
    @Test(enabled = false, priority = 4)
    public void testDepartmentDelete(){
        System.out.println("---TESTPATIENTDELETE---");
        
        patientCrudService.remove(patientCrudService.findById(id));
        
        Assert.assertNull(patientCrudService.findById(id));
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-connection.xml");
        patientCrudService = (PatientCrudService) ctx.getBean("patientCrudService");
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