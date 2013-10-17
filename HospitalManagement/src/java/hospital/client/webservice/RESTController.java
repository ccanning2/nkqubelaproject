/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Department;
import hospital.services.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author GizelleHeunis
 */
@Controller
@RequestMapping("api")
public class RESTController {
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private DepartmentResourceAssembler departmentResourceAssembler;
    
    @RequestMapping(method = RequestMethod.GET) 
    ResponseEntity<List<DepartmentResource>> getDepartments() {   
        List<Department> d = departmentService.getDepartment();   
        List<DepartmentResource> resourceList = departmentResourceAssembler.toResources(d);  
        return new ResponseEntity<List<DepartmentResource>>(resourceList, HttpStatus.OK);  
    } 
    
    @ExceptionHandler 
    ResponseEntity handleExceptions(Exception ex) {  
      ResponseEntity responseEntity = null;     
      responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);   
      return responseEntity;  
    } 
}
 