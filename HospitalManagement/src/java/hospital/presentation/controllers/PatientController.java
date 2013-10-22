/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.entities.Department;
import hospital.model.entities.Patient;
import hospital.presentation.models.DepartmentModel;
import hospital.presentation.models.PatientModel;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Enzo
 */

@Controller
public class PatientController {    
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewPatients.html", method = RequestMethod.GET)
    public String viewMessages(Model model) 
    {        
        List<Patient> patient = data.getPatientCrudService().findAll();
        
        model.addAttribute("patients", patient);
        
        return "hospital/viewPatients";
    }
    
    @RequestMapping(value = "/addPatient.html", method = RequestMethod.GET)
    public String addPatient(Model model) 
    {
        PatientModel patientModel = new PatientModel();
        model.addAttribute("patientModelModel", patientModel);

        return "hospital/addPatients";
    }
    
    @RequestMapping(value = "/deletePatient.html", method = RequestMethod.GET)
    public String deletePatient(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        PatientModel patientModel = new PatientModel();
         List<Patient> patientList = data.getPatientCrudService().findAll();
         Patient patient;
        
        patient = data.getPatientCrudService().findById(pk);

        if(pk != -6){
            patientModel.setName(patient.getFName());
            patientModel.setId(id);
        }else{
            patientModel.setName("");
            
            
        }
     
        model.addAttribute("patientList", patientList);
        model.addAttribute("patientList", patientModel);
        
        return "hospital/deletePatient";
    }
    
    @RequestMapping(value = "/editPatient.html", method = RequestMethod.GET)
    public String editPatient(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        PatientModel patientModel = new PatientModel();
        Patient patient;
        
        patient = data.getPatientCrudService().findById(id);

        patientModel.setName(patient.getFName());
        patientModel.setDateOfArrival(patient.getDateOfArrival());
        patientModel.setPatientNumber(patient.getPatientNumber());
        patientModel.setReasonForStay(patient.getReasonForStay());
        model.addAttribute("patientModel", patientModel);
        
        return "hospital/editDepartment";
    }
    
    @RequestMapping(value = "/mergePatient.php", method = RequestMethod.POST)
    public String merge(PatientModel patientModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Patient  patient= data.getPatientCrudService().findById(id);
        Contact contact = new Contact();
        
         

        patient.setFName(patient.getFName());
        patient.setDateOfArrival(patient.getDateOfArrival());
  
        
        patient.setPatientNumber(patient.getPatientNumber());
        patient.setCurrentCondition(patient.getCurrentCondition());
        patient.setReasonForStay(patient.getReasonForStay());
        
        
        patient.setContact(contact);

        data.getPatientCrudService().merge(patient);

        return "hospital/result";
    }

    @RequestMapping(value = "/removePatient.php", method = RequestMethod.GET)
    public String remove(PatientModel patientModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }

        Patient patient = data.getPatientCrudService().findById(patientModel.getId());

        data.getPatientCrudService().remove(patient);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistPatient.php", method = RequestMethod.POST)
    public String persist(PatientModel patientModel, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();

        stringValues.put("name", patientModel.getName());
         stringValues.put("bedNumber", "1");
        stringValues.put("dateofArrival","23-11-2013");
        stringValues.put("medicalAidID", "1");
        stringValues.put("patientNumber","1111");
        stringValues.put("reasonForStay",patientModel.getReasonForStay());        
        
        
        Patient patient = AppFactory.getPatient(stringValues,  1, 1);

        data.getPatientCrudService().persist(patient);

        return "hospital/result";
    }
}