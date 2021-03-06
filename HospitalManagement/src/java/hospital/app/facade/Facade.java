package hospital.app.facade;

import hospital.app.config.GetContext;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.MedicalAidCrudService;
import hospital.services.crud.PatientCrudService;
import hospital.services.crud.PersonCrudService;
import hospital.services.crud.ShoeboxItemCrudService;
import hospital.services.crud.StaffMemberCrudService;
import hospital.services.crud.WardCrudService;

import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Hospital Management
 */

public class Facade implements Serializable {
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private DepartmentCrudService departmentCrudService;    
    private PersonCrudService personCrudService;    
    private StaffMemberCrudService staffMemberCrudService;    
    private PatientCrudService patientCrudService;    
    private WardCrudService wardCrudService;    
    private MedicalAidCrudService medicalAidCrudService;
    private ShoeboxItemCrudService shoeboxItemCrudService;    

    public DepartmentCrudService getDepartmentCrudService() {
        departmentCrudService = (DepartmentCrudService) ctx.getBean("departmentCrudService");
        return departmentCrudService;
    }
    
    public PersonCrudService getPersonCrudService() {
        personCrudService = (PersonCrudService) ctx.getBean("personCrudService");
        return personCrudService;
    }
    
    public StaffMemberCrudService getStaffMemberCrudService() {
        staffMemberCrudService = (StaffMemberCrudService) ctx.getBean("staffMemberCrudService");
        return staffMemberCrudService;
    }
    
    public PatientCrudService getPatientCrudService() {
        patientCrudService = (PatientCrudService) ctx.getBean("patientCrudService");
        return patientCrudService;
    }
    
    public WardCrudService getWardCrudService() {
        wardCrudService = (WardCrudService) ctx.getBean("wardCrudService");
        return wardCrudService;
    }
    
    public MedicalAidCrudService getMedicalAidCrudService() {
        medicalAidCrudService = (MedicalAidCrudService) ctx.getBean("medicalAidCrudService");
        return medicalAidCrudService;
    }
    
    public ShoeboxItemCrudService getShoeboxItemCrudService() {
        shoeboxItemCrudService = (ShoeboxItemCrudService) ctx.getBean("shoeboxItemCrudService");
        return shoeboxItemCrudService;
    }
}