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
import hospital.presentation.models.PatientModel;
import hospital.presentation.models.StaffMemberModel;
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
public class StaffMemberController {    
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewStaffMember.html", method = RequestMethod.GET)
    public String viewStaffMember(Model model, HttpServletRequest req) 
    {        
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        StaffMember staffMember = data.getStaffMemberCrudService().findById(pk);
        
        model.addAttribute("person", staffMember);
        
        return "hospital/viewStaffMember";
    }
  
    @RequestMapping(value = "/viewStaffMembers.html", method = RequestMethod.GET)
    public String viewStaffMembers(Model model) 
    {        
        List<StaffMember> staffMembers = data.getStaffMemberCrudService().findAll();
        
        model.addAttribute("person", staffMembers);
        
        return "hospital/viewStaffMembers";
    }
    
    @RequestMapping(value = "/addStaffMember.html", method = RequestMethod.GET)
    public String addStaffMember(Model model) 
    {
        StaffMemberModel staffMemberModel = new StaffMemberModel();
        model.addAttribute("staffMemberModel", staffMemberModel);
        //model.addAttribute("wardList", data.getWardCrudService().findAll());
        
        return "hospital/addStaffMember";
    }
    
    @RequestMapping(value = "/deleteStaffMember.html", method = RequestMethod.GET)
    public String deleteStaffMember(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        StaffMemberModel staffMemberModel = new StaffMemberModel();
        List<StaffMember> staffMemberList = data.getStaffMemberCrudService().findAll();
        StaffMember staffMember;
        
        staffMember = data.getStaffMemberCrudService().findById(pk);

        if(pk != -6){
            staffMemberModel.setFirstName(staffMember.getName().getFirstName());
            staffMemberModel.setLastName(staffMember.getName().getLastName());
            staffMemberModel.setId(id);
        }else{
            staffMemberModel.setFirstName("");
            staffMemberModel.setLastName("");
        }
     
        model.addAttribute("staffMemberList", staffMemberList);
        model.addAttribute("staffMemberModel", staffMemberModel);
        
        return "hospital/deleteStaffMember";
    }
    
    @RequestMapping(value = "/editStaffMember.html", method = RequestMethod.GET)
    public String editStaffMember(HttpServletRequest req, Model model) throws ServletRequestBindingException, ParseException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        StaffMemberModel staffMemberModel = new StaffMemberModel();
        StaffMember staffMember;
        
        staffMember = data.getStaffMemberCrudService().findById(id);

        staffMemberModel.setFirstName(staffMember.getName().getFirstName());
        staffMemberModel.setLastName(staffMember.getName().getLastName());
        //patientModel.setDateOfArrival(patient.getDateOfArrival());
        //patientModel.setPatientNumber(patient.getPatientNumber());
        //patientModel.setReasonForStay(patient.getReasonForStay());
        model.addAttribute("staffMember", staffMember);
        
        return "hospital/editStaffMember";
    }
    
    @RequestMapping(value = "/mergeStaffMember.php", method = RequestMethod.POST)
    public String mergeStaffMember(PatientModel patientModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        StaffMember  staffMember = data.getStaffMemberCrudService().findById(id);
        Contact contact = new Contact();

        staffMember.getName().setFirstName(staffMember.getName().getFirstName());
        staffMember.getName().setLastName(staffMember.getName().getLastName());
        //patient.setDateOfArrival(patient.getDateOfArrival());       
        //patient.setPatientNumber(patient.getPatientNumber());
        //patient.setCurrentCondition(patient.getCurrentCondition());
        //patient.setReasonForStay(patient.getReasonForStay());       
        //patient.setContact(contact);

        data.getStaffMemberCrudService().merge(staffMember);

        return "hospital/result";
    }

    @RequestMapping(value = "/removeStaffMember.php", method = RequestMethod.GET)
    public String removeStaffMember(StaffMemberModel staffMemberModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }

        StaffMember staffMember = data.getStaffMemberCrudService().findById(staffMemberModel.getId());

        data.getPersonCrudService().remove(staffMember);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistStaffMember.php", method = RequestMethod.POST)
    public String persistStaffMember(StaffMemberModel staffMemberModel, BindingResult result) throws ParseException 
    {
        if(result.hasErrors()) 
        {
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("firstName", staffMemberModel.getFirstName());
        stringValues.put("lastName", staffMemberModel.getLastName());
        //stringValues.put("middleName", patientModel.getMiddleName());
        //stringValues.put("nickName", patientModel.getNickName());
        //stringValues.put("contactNumber", patientModel.getContactNumber());
        //stringValues.put("emailAddress", patientModel.getEmailAddress());
        //stringValues.put("gender", patientModel.getGender());
        //stringValues.put("race", patientModel.getRace());
        //stringValues.put("title", patientModel.getTitle());
        //stringValues.put("identityNumber", patientModel.getIdentityNumber());
        //stringValues.put("currentCondition", patientModel.getCurrentCondition());

        //stringValues.put("medicalAidName", patientModel.getMedicalAidName());
        //stringValues.put("medicalAidScheme", patientModel.getMedicalAidScheme());
        //stringValues.put("reasonForStay",patientModel.getReasonForStay());        
        
        StaffMember staffMember = AppFactory.getStaffMember(stringValues, staffMemberModel.getStaffNumber(), new Date());

        data.getStaffMemberCrudService().persist(staffMember);

        return "hospital/result";
    }
}