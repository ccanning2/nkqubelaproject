/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.entities.Patient;
import hospital.model.entities.StaffMember;
import hospital.model.entities.Ward;
import hospital.presentation.models.PatientModel;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Hospital Management
 */

@Controller
public class PatientController {    
    private final Facade data = new Facade();
    private static long id;
    
    @RequestMapping(value = "/viewPatient.html", method = RequestMethod.GET)
    public String viewPatient(Model model, HttpServletRequest req) 
    {        
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        StaffMember staffMember = data.getStaffMemberCrudService().findById(pk);
        
        model.addAttribute("person", staffMember);
        
        return "hospital/viewPatient";
    }
  
    @RequestMapping(value = "/viewPatients.html", method = RequestMethod.GET)
    public String viewPatients(Model model) 
    {        
        List<Patient> patients = data.getPatientCrudService().findAll();
        
        model.addAttribute("patients", patients);
        
        return "hospital/viewPatients";
    }
    
    @RequestMapping(value = "/addPatient.html", method = RequestMethod.GET)
    public String addPatient(Model model) 
    {
        PatientModel patientModel = new PatientModel();
        model.addAttribute("patientModel", patientModel);
        model.addAttribute("wardList", data.getWardCrudService().findAll());
        
        return "hospital/addPatient";
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
            patientModel.setFirstName(patient.getName().getFirstName());
            patientModel.setLastName(patient.getName().getLastName());
            patientModel.setId(id);
        }else{
            patientModel.setFirstName("");
            patientModel.setLastName("");
        }
     
        model.addAttribute("patientList", patientList);
        model.addAttribute("patientModel", patientModel);
        
        return "hospital/deletePatient";
    }
    
    @RequestMapping(value = "/deletePatientFromTable.html", method = RequestMethod.GET)
    public String deletePatientFromTable(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        Patient patient;
        
        patient = data.getPatientCrudService().findById(pk);
        data.getPatientCrudService().remove(patient);
        
        return "hospital/result";
    }
    
    @RequestMapping(value = "/editPatient.html", method = RequestMethod.GET)
    public String editPatient(HttpServletRequest req, Model model) throws ServletRequestBindingException, ParseException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        PatientModel patientModel = new PatientModel();
        Patient patient;
        
        patient = data.getPatientCrudService().findById(id);

        patientModel.setFirstName(patient.getName().getFirstName());
        patientModel.setLastName(patient.getName().getLastName());
        patientModel.setMiddleName(patient.getName().getMiddleName());
        patientModel.setNickName(patient.getName().getNickName());
        patientModel.setEmailAddress(patient.getContact().getEmailAddress());
        patientModel.setContactNumber(patient.getContact().getContactNumber());
        patientModel.setIdentityNumber(patient.getIdentityNumber());
        patientModel.setBedNumber(patient.getBedNumber());
        patientModel.setCurrentCondition(patient.getCurrentCondition());
        patientModel.setDateOfBirth(patient.getDemographic().getDateOfBirth());
        patientModel.setDateOfArrival(patient.getDateOfArrival());
        patientModel.setPatientNumber(patient.getPatientNumber());
        patientModel.setReasonForStay(patient.getReasonForStay());
        patientModel.setGender(patient.getDemographic().getGender());
        patientModel.setRace(patient.getDemographic().getRace());
        patientModel.setTitle(patient.getDemographic().getTitle());
        patientModel.setPatientNumber(patient.getPatientNumber());
        patientModel.setMedicalAidName(patient.getMedicalAid().getMedicalAidName());
        patientModel.setMedicalAidNumber(patient.getMedicalAid().getMedicalAidNumber());
        patientModel.setMedicalAidScheme(patient.getMedicalAid().getMedicalAidScheme());
        patientModel.setHasMedicalAid(patient.getMedicalAid().getMedicalAidNumber() != null ? true : false);
        model.addAttribute("patientModel", patientModel);
        model.addAttribute("wardList", data.getWardCrudService().findAll());
        
        return "hospital/editPatient";
    }
    
    @RequestMapping(value = "/mergePatient.php", method = RequestMethod.POST)
    public String merge(PatientModel patientModel, BindingResult result, HttpServletRequest req) throws ParseException 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Patient  patient = data.getPatientCrudService().findById(id);

        patient.getName().setFirstName(patientModel.getFirstName());
        patient.getName().setLastName(patientModel.getLastName());
        patient.getName().setMiddleName(patientModel.getMiddleName());
        patient.getName().setNickName(patientModel.getNickName());
        patient.getContact().setEmailAddress(patientModel.getEmailAddress());
        patient.getContact().setContactNumber(patientModel.getContactNumber());
        patient.setIdentityNumber(patientModel.getIdentityNumber());
        patient.setBedNumber(patientModel.getBedNumber());
        patient.setCurrentCondition(patientModel.getCurrentCondition());
        patient.getDemographic().setDateOfBirth(patientModel.getDateOfBirth());
        patient.setDateOfArrival(patientModel.getDateOfArrival());
        patient.setPatientNumber(patientModel.getPatientNumber());
        patient.setReasonForStay(patientModel.getReasonForStay());
        patient.getDemographic().setGender(patientModel.getGender());
        patient.getDemographic().setRace(patientModel.getRace());
        patient.getDemographic().setTitle(patientModel.getTitle());
        patient.getMedicalAid().setMedicalAidName(patientModel.getMedicalAidName());
        patient.getMedicalAid().setMedicalAidNumber(patientModel.getMedicalAidNumber());
        patient.getMedicalAid().setMedicalAidScheme(patientModel.getMedicalAidScheme());
        patient.setWard(data.getWardCrudService().findById(patientModel.getWard()));

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

        data.getPersonCrudService().remove(patient);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistPatient.php", method = RequestMethod.POST)
    public String persist(PatientModel patientModel, BindingResult result) throws ParseException 
    {
        if(result.hasErrors()) 
        {
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();
        Map<String, Long> longValues = new HashMap<String, Long>();
        Map<String, Date> dateValues = new HashMap<String, Date>();
        
        stringValues.put("firstName", patientModel.getFirstName());
        stringValues.put("lastName", patientModel.getLastName());
        stringValues.put("middleName", patientModel.getMiddleName());
        stringValues.put("nickName", patientModel.getNickName());
        stringValues.put("contactNumber", patientModel.getContactNumber());
        stringValues.put("emailAddress", patientModel.getEmailAddress());
        stringValues.put("gender", patientModel.getGender());
        stringValues.put("race", patientModel.getRace());
        stringValues.put("title", patientModel.getTitle());
        stringValues.put("identityNumber", patientModel.getIdentityNumber());
        stringValues.put("currentCondition", patientModel.getCurrentCondition());

        stringValues.put("medicalAidName", patientModel.getMedicalAidName());
        stringValues.put("medicalAidScheme", patientModel.getMedicalAidScheme());
        stringValues.put("reasonForStay",patientModel.getReasonForStay());  
        
        longValues.put("medicalAidNumber", patientModel.getMedicalAidNumber());
        longValues.put("bedNumber", patientModel.getBedNumber());
        longValues.put("patientNumber", patientModel.getPatientNumber());
        
        dateValues.put("dateOfArrival", patientModel.getDateOfArrival());
        dateValues.put("dateOfBirth", patientModel.getDateOfBirth());
        dateValues.put("estimatedDateOfDischarge", patientModel.getEstimatedDateOfDeparture());
        
        Ward ward = data.getWardCrudService().findById(patientModel.getWard());
        
        Patient patient = AppFactory.getPatient(stringValues, longValues, dateValues, patientModel.getHasMedicalAid(), ward);

        data.getPatientCrudService().persist(patient);

        return "hospital/result";
    }
}