/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.entities.MedicalAid;
import hospital.model.entities.Patient;
import hospital.model.entities.Ward;
import hospital.services.crud.MedicalAidCrudService;
import hospital.services.crud.PatientCrudService;
import hospital.services.crud.WardCrudService;
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

public class PatientTest {
    
    private static PatientCrudService patientCrudService;
    private static MedicalAidCrudService medicalAidCrudService;
    private static WardCrudService wardCrudService;
    private static long id;    
    private static ApplicationContext ctx;
    
    public PatientTest(){
    }
    
    @Test(priority = 1)
    @SuppressWarnings({"null", "ConstantConditions"})
    public void testPatientCreate(){
        System.out.println("---TESTPATIENTCREATE---");
        Patient patient;
        Ward ward;
        MedicalAid medicalAid = new MedicalAid();
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("firstName", "Peter");
        stringValues.put("lastName", "Jones");
        stringValues.put("middleName", "Bobby");
        stringValues.put("nickName", "Pet");
        stringValues.put("contactNumber", "0726289563");
        stringValues.put("emailAddress", "peterb@jones.co.za");
        stringValues.put("gender", "Male");
        stringValues.put("race", "White");
        stringValues.put("title", "Dr");
        stringValues.put("identityNumber", "8512206201951");
        stringValues.put("currentCondition", "Critical");

        stringValues.put("medicalAidName", "Dicovery Health");
        stringValues.put("medicalAidScheme", "Full");
        stringValues.put("reasonForStay","Heart Transplant");  
        
        Map<String, Long> longValues = new HashMap<String, Long>();
        
        longValues.put("medicalAidNumber", (long)025632);
        longValues.put("bedNumber", (long)4588);
        longValues.put("patientNumber", (long)9515);
        
        Map<String, Date> dateValues = new HashMap<String, Date>();
        
        dateValues.put("dateOfArrival", new Date());
        dateValues.put("dateOfBirth", new Date());
        dateValues.put("estimatedDateOfDischarge", new Date());
    
        medicalAid.setMedicalAidName(stringValues.get("medicalAidName"));
        medicalAid.setMedicalAidNumber(longValues.get("medicalAidNumber"));
        medicalAid.setMedicalAidScheme(stringValues.get("medicalAidScheme"));
        
        medicalAidCrudService.persist(medicalAid);
        
        ward = wardCrudService.findById((long)1);                
        
        patient = AppFactory.getPatient(stringValues, longValues, dateValues, Boolean.TRUE, ward);

        patientCrudService.persist(patient);
        
        id = patient.getId();
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
    }
    
    @Test(priority = 3)
    public void testPatientUpdate(){
        System.out.println("---TESTPATIENTUPDATE---");
        Patient patient = patientCrudService.findById(id);
        
        patient.setCurrentCondition("AIDS");
        patient.getName().setFirstName("John");
        
        patientCrudService.merge(patient);
        
        Assert.assertEquals(patient.getName().getFirstName(), "John");
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
        medicalAidCrudService = (MedicalAidCrudService) ctx.getBean("medicalAidCrudService");
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