/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
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
 * @author Chris
 */

@Controller
public class WardController {    
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewWards.html", method = RequestMethod.GET)
    public String viewWard(Model model) 
    {        
        List<Ward> wards = data.getWardCrudService().findAll();
        
        model.addAttribute("wards", wards);
        
        return "hospital/viewWards";
    }
    
    @RequestMapping(value = "/addWard.html", method = RequestMethod.GET)
    public String addWard(Model model) 
    {
        model.addAttribute("wardModel", new WardModel());
        model.addAttribute("personInChargeList", data.getStaffMemberCrudService().findAll());

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
            //departmentModel.setName(department.getName());
            //departmentModel.setId(id);
        }else{
            //departmentModel.setName("");
        }
     
        model.addAttribute("wardList", wardList);
        model.addAttribute("wardModel", wardModel);
        
        return "hospital/deleteWard";
    }
    
    @RequestMapping(value = "/editWard.html", method = RequestMethod.GET)
    public String editWard(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        WardModel wardModel = new WardModel();
        Ward ward;
        
        ward = data.getWardCrudService().findById(id);

        //departmentModel.setDescription(department.getDescription());
        //departmentModel.setFloorNumber(department.getFloorNumber());
        //departmentModel.setName(department.getName());
        //departmentModel.setPersonInCharge(department.getPersonInCharge());
        //departmentModel.setSize(department.getDepartmentSize());
        //departmentModel.setContactNumber(department.getContact().getContactNumber());
        //departmentModel.setEmailAddress(department.getContact().getEmailAddress());
        model.addAttribute("wardModel", wardModel);
        
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
        //Contact contact = new Contact();

        //department.setDescription(departmentModel.getDescription());
        //department.setFloorNumber(departmentModel.getFloorNumber());
        //department.setName(departmentModel.getName());
        //department.setPersonInCharge(departmentModel.getPersonInCharge());
        //department.setDepartmentSize(departmentModel.getSize());
        
        //System.out.println("departmentModel.getContactNumber(): " + departmentModel.getContactNumber());
        //System.out.println("departmentModel.getEmailAddress(): " + departmentModel.getEmailAddress());
        
        //contact.setContactNumber(departmentModel.getContactNumber());
        //contact.setEmailAddress(departmentModel.getEmailAddress());
        
        //department.setContact(contact);

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

        //Ward ward = data.getWardCrudService().findById(wardModel.getId());

        //data.getWardCrudService().remove(ward);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistWard.php", method = RequestMethod.POST)
    public String persist(WardModel wardModel, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();

        stringValues.put("name", wardModel.getName());
        stringValues.put("visitinHoursStart", wardModel.getVisitingHoursStart());
        stringValues.put("visitinHoursEnd", wardModel.getVisitingHoursEnd());
        stringValues.put("emailAddress", wardModel.getEmailAddress());
        stringValues.put("contactNumber", wardModel.getContactNumber());        
        
        Ward ward = AppFactory.getWard(stringValues, wardModel.getFloorNumber(), wardModel.getWardNumber(), wardModel.getPersonInCharge());

        //data.getDepartmentCrudService().persist(department);

        return "hospital/result";
    }
}