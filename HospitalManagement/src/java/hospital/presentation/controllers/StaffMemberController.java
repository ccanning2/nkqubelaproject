/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.embeddables.Demographic;
import hospital.model.embeddables.Name;
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
  
    @RequestMapping(value = "/viewStaffMembers.html", method = RequestMethod.GET)
    public String viewStaffMembers(Model model) 
    {
        model.addAttribute("staffMembers", data.getStaffMemberCrudService().findAll());
        
        return "hospital/viewStaffMembers";
    }
    
    @RequestMapping(value = "/viewStaffMember.html", method = RequestMethod.GET)
    public String viewStaffMember(Model model, HttpServletRequest req) 
    {        
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        StaffMember staffMember = data.getStaffMemberCrudService().findById(pk);
        
        model.addAttribute("person", staffMember);
        
        return "hospital/viewStaffMember";
    }    
    
    @RequestMapping(value = "/addStaffMember.html", method = RequestMethod.GET)
    public String addStaffMember(Model model) 
    {
        StaffMemberModel staffMemberModel = new StaffMemberModel();
        model.addAttribute("staffMemberModel", staffMemberModel);
        model.addAttribute("wardList", data.getWardCrudService().findAll()); //TODO: Add ward list DD in jsp
        
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
    
    @RequestMapping(value = "/deleteStaffMemberFromTable.html", method = RequestMethod.GET)
    public String deleteStaffMemberFromTable(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        StaffMember staffMember;
        
        staffMember = data.getStaffMemberCrudService().findById(pk);
        data.getStaffMemberCrudService().remove(staffMember);
        
        return "hospital/result";
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
        staffMemberModel.setContactNumber(staffMember.getContact().getContactNumber());
        staffMemberModel.setEmailAddress(staffMember.getContact().getEmailAddress());
        staffMemberModel.setStartTime(staffMember.getStartTime());
        staffMemberModel.setEndTime(staffMember.getEndTime());
        staffMemberModel.setGender(staffMember.getDemographic().getGender());
        staffMemberModel.setRace(staffMember.getDemographic().getRace());
        staffMemberModel.setTitle(staffMember.getDemographic().getTitle());
        staffMemberModel.setStaffNumber(staffMember.getStaffNumber());
        staffMemberModel.setType(staffMember.getType());
        staffMemberModel.setField(staffMember.getField());

        model.addAttribute("staffMemberModel", staffMemberModel);
        
        return "hospital/editStaffMember";
    }
    
    @RequestMapping(value = "/mergeStaffMember.php", method = RequestMethod.POST)
    public String mergeStaffMember(StaffMemberModel staffMemberModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        StaffMember  staffMember = data.getStaffMemberCrudService().findById(id);
        Contact contact = new Contact();
        Demographic demographic = new Demographic();
        Name name = new Name();
        
        contact.setContactNumber(staffMemberModel.getContactNumber());
        contact.setEmailAddress(staffMemberModel.getEmailAddress());
        
        demographic.setGender(staffMemberModel.getGender());
        demographic.setRace(staffMemberModel.getRace());
        demographic.setTitle(staffMemberModel.getTitle());
        
        name.setFirstName(staffMember.getName().getFirstName());
        name.setLastName(staffMember.getName().getLastName());
        name.setMiddleName(staffMember.getName().getMiddleName());
        name.setNickName(staffMember.getName().getNickName());
                
        staffMember.setName(name);
        staffMember.setContact(contact);
        staffMember.setDemographic(demographic);
        staffMember.setEndTime(staffMemberModel.getEndTime());
        staffMember.setField(staffMemberModel.getField());
        staffMember.setIdentityNumber(staffMemberModel.getIdentityNumber());
        staffMember.setStaffNumber(staffMemberModel.getStaffNumber());
        staffMember.setStartTime(staffMemberModel.getStartTime());
        staffMember.setType(staffMemberModel.getType());
        //staffMember.setWard(null); TODO: Add ward to creating

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
        stringValues.put("middleName", staffMemberModel.getMiddleName());
        stringValues.put("nickName", staffMemberModel.getNickName());
        stringValues.put("contactNumber", staffMemberModel.getContactNumber());
        stringValues.put("emailAddress", staffMemberModel.getEmailAddress());
        stringValues.put("gender", staffMemberModel.getGender());
        stringValues.put("race", staffMemberModel.getRace());
        stringValues.put("title", staffMemberModel.getTitle());
        stringValues.put("identityNumber", staffMemberModel.getIdentityNumber());     
        
        //TODO: change new Date() to dateOfBirth
        StaffMember staffMember = AppFactory.getStaffMember(stringValues, staffMemberModel.getStaffNumber(), new Date());

        data.getStaffMemberCrudService().persist(staffMember);

        return "hospital/result";
    }
}