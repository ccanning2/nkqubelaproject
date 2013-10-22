/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.embeddables.Contact;
import hospital.model.entities.Department;
import hospital.presentation.models.DepartmentModel;
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
 * @author Chris
 */

@Controller
public class DepartmentController {    
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewDepartments.html", method = RequestMethod.GET)
    public String viewMessages(Model model) 
    {        
        List<Department> departments = data.getDepartmentCrudService().findAll();
        
        model.addAttribute("departments", departments);
        
        return "hospital/viewDepartments";
    }
    
    @RequestMapping(value = "/addDepartment.html", method = RequestMethod.GET)
    public String addDepartment(Model model) 
    {
        DepartmentModel departmentModel = new DepartmentModel();
        model.addAttribute("departmentModel", departmentModel);

        return "hospital/addDepartment";
    }
    
    @RequestMapping(value = "/deleteDepartment.html", method = RequestMethod.GET)
    public String deleteDepartment(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        DepartmentModel departmentModel = new DepartmentModel();
        List<Department> departmentList = data.getDepartmentCrudService().findAll();
        Department department;
        
        department = data.getDepartmentCrudService().findById(pk);

        if(pk != -6){
            departmentModel.setName(department.getName());
            departmentModel.setId(id);
        }else{
            departmentModel.setName("");
        }
     
        model.addAttribute("departmentList", departmentList);
        model.addAttribute("departmentModel", departmentModel);
        
        return "hospital/deleteDepartment";
    }
    
    @RequestMapping(value = "/editDepartment.html", method = RequestMethod.GET)
    public String editDepartment(HttpServletRequest req, Model model) throws ServletRequestBindingException
    {
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        DepartmentModel departmentModel = new DepartmentModel();
        Department department;
        
        department = data.getDepartmentCrudService().findById(id);

        departmentModel.setDescription(department.getDescription());
        departmentModel.setFloorNumber(department.getFloorNumber());
        departmentModel.setName(department.getName());
        departmentModel.setPersonInCharge(department.getPersonInCharge());
        departmentModel.setSize(department.getDepartmentSize());
        departmentModel.setContactNumber(department.getContact().getContactNumber());
        departmentModel.setEmailAddress(department.getContact().getEmailAddress());
        model.addAttribute("departmentModel", departmentModel);
        
        return "hospital/editDepartment";
    }
    
    @RequestMapping(value = "/mergeDepartment.php", method = RequestMethod.POST)
    public String merge(DepartmentModel departmentModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Department department = data.getDepartmentCrudService().findById(id);
        Contact contact = new Contact();

        department.setDescription(departmentModel.getDescription());
        department.setFloorNumber(departmentModel.getFloorNumber());
        department.setName(departmentModel.getName());
        department.setPersonInCharge(departmentModel.getPersonInCharge());
        department.setDepartmentSize(departmentModel.getSize());
        
        System.out.println("departmentModel.getContactNumber(): " + departmentModel.getContactNumber());
        System.out.println("departmentModel.getEmailAddress(): " + departmentModel.getEmailAddress());
        
        contact.setContactNumber(departmentModel.getContactNumber());
        contact.setEmailAddress(departmentModel.getEmailAddress());
        
        department.setContact(contact);

        data.getDepartmentCrudService().merge(department);

        return "hospital/result";
    }

    @RequestMapping(value = "/removeDepartment.php", method = RequestMethod.GET)
    public String remove(DepartmentModel departmentModel, BindingResult result, HttpServletRequest req) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }

        Department department = data.getDepartmentCrudService().findById(departmentModel.getId());

        data.getDepartmentCrudService().remove(department);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/persistDepartment.php", method = RequestMethod.POST)
    public String persist(DepartmentModel departmentModel, BindingResult result) 
    {
        if (result.hasErrors()) 
        {
            return "error";
        }
        
        Map<String, String> stringValues = new HashMap<String, String>();

        stringValues.put("name", departmentModel.getName());
        stringValues.put("description", departmentModel.getDescription());
        stringValues.put("email", departmentModel.getEmailAddress());
        stringValues.put("contactNumber", departmentModel.getContactNumber());        
        
        
        Department department = AppFactory.getDepartment(stringValues, departmentModel.getFloorNumber(), departmentModel.getSize(), departmentModel.getPersonInCharge());

        data.getDepartmentCrudService().persist(department);

        return "hospital/result";
    }
}