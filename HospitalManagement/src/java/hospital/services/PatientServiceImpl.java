/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import hospital.model.entities.Department;
import hospital.model.entities.Patient;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.PatientCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/**
 *
 * @author Enzo
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {
    
    @Autowired
    private PatientCrudService patientCrudService;
    
  //  private static ApplicationContext ctx;
    
    @Override
    public List<Patient> getPatient()
    {
       // ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-*.xml");
        //departmentCrudService = (DepartmentCrudService)ctx.getBean("departmentCrudService");
        
        return patientCrudService.findAll();
    }
            
}
    
