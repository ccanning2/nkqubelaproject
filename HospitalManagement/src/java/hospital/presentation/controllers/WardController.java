/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.entities.Ward;
import hospital.presentation.models.WardModel;
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
 * @author Gizelle
 */

@Controller
public class WardController {    
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewWards.html", method = RequestMethod.GET)
    public String viewWards(Model model) 
    {
        model.addAttribute("wards", data.getWardCrudService().findAll());        
        
        return "hospital/viewWards";
    }
    
    @RequestMapping(value = "/addWard.html", method = RequestMethod.GET)
    public String addWard(Model model) 
    {
        model.addAttribute("wardModel", new WardModel());
        model.addAttribute("personInChargeList", data.getStaffMemberCrudService().findAll());
        model.addAttribute("departmentList", data.getDepartmentCrudService().findAll());
        
        return "hospital/addWard";
    }
    
    @RequestMapping(value = "/deleteWard.html", method = RequestMethod.GET)
    public String deleteWard(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        WardModel wardModel = new WardModel();
        List<Ward> wardList = data.getWardCrudService().findAll();
        Ward ward;
        
        ward = data.getWardCrudService().findById(pk);

        if(pk != -6){
            wardModel.setName(ward.getName());
            wardModel.setId(pk);
        }else{
            wardModel.setName("");
        }
     
        model.addAttribute("wardList", wardList);
        model.addAttribute("wardModel", wardModel);
        
        return "hospital/deleteWard";
    }
    
    @RequestMapping(value = "/deleteWardFromTable.html", method = RequestMethod.GET)
    public String deleteWardFromTable(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        Ward ward;
        
        ward = data.getWardCrudService().findById(pk);
        data.getWardCrudService().remove(ward);
        
        return "hospital/result";
    }
    
    @RequestMapping(value = "/editWard.html", method = RequestMethod.GET)
    public String editWard(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        WardModel wardModel = new WardModel();
        Ward ward;
        
        ward = data.getWardCrudService().findById(id);

        wardModel.setName(ward.getName());
        wardModel.setContactNumber(ward.getContact().getContactNumber());
        wardModel.setEmailAddress(ward.getContact().getEmailAddress());
        wardModel.setFloorNumber(ward.getFloorNumber());
        wardModel.setPersonInCharge(ward.getPersonInCharge().getId());
        wardModel.setVisitingHoursStart(ward.getVisitingHoursStart());
        wardModel.setVisitingHoursEnd(ward.getVisitingHoursEnd());
        wardModel.setWardNumber(ward.getWardNumber());
        wardModel.setDepartment(ward.getDepartment().getId());
        model.addAttribute("wardModel", wardModel);
        model.addAttribute("personInChargeList", data.getStaffMemberCrudService().findAll());
        model.addAttribute("departmentList", data.getDepartmentCrudService().findAll());
        
        return "hospital/editWard";
    }
    
    @RequestMapping(value = "/mergeWard.php", method = RequestMethod.POST)
    public String mergeWard(WardModel wardModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Ward ward = data.getWardCrudService().findById(id);
        Contact contact = new Contact();

        contact.setContactNumber(wardModel.getContactNumber());
        contact.setEmailAddress(wardModel.getEmailAddress());
        
        ward.setContact(contact);
        ward.setFloorNumber(wardModel.getFloorNumber());
        ward.setName(wardModel.getName());
        ward.setPersonInCharge(data.getStaffMemberCrudService().findById(wardModel.getPersonInCharge()));
        ward.setVisitingHoursStart(wardModel.getVisitingHoursStart());
        ward.setVisitingHoursEnd(wardModel.getVisitingHoursEnd());
        ward.setWardNumber(wardModel.getWardNumber());
        ward.setDepartment(data.getDepartmentCrudService().findById(wardModel.getDepartment()));

        data.getWardCrudService().merge(ward);

        return "hospital/result";
    }

    @RequestMapping(value = "/removeWard.php", method = RequestMethod.GET)
    public String removeWard(WardModel wardModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }

        Ward ward = data.getWardCrudService().findById(wardModel.getId());

        data.getWardCrudService().remove(ward);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistWard.php", method = RequestMethod.POST)
    public String persist(WardModel wardModel, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            System.out.println("ERRORS: " + result.getAllErrors());
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();

        stringValues.put("name", wardModel.getName());
        stringValues.put("visitingHoursStart", wardModel.getVisitingHoursStart());
        stringValues.put("visitingHoursEnd", wardModel.getVisitingHoursEnd());
        stringValues.put("emailAddress", wardModel.getEmailAddress());
        stringValues.put("contactNumber", wardModel.getContactNumber());   
        
        Ward ward = AppFactory.getWard(stringValues, wardModel.getFloorNumber(), wardModel.getWardNumber(), data.getStaffMemberCrudService().findById(wardModel.getPersonInCharge()), data.getDepartmentCrudService().findById(wardModel.getDepartment()));

        data.getWardCrudService().persist(ward);

        return "hospital/result";
    }
}