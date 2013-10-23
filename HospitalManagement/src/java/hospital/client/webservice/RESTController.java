/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Department;
import hospital.model.entities.Patient;
import hospital.model.entities.StaffMember;
import hospital.model.entities.Ward;
import hospital.services.DepartmentService;
import hospital.services.PatientService;
import hospital.services.StaffMemberService;
import hospital.services.WardService;
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
 * @author Enzo
 */
@Controller
@RequestMapping("api")
public class RESTController {
    @Autowired
    private DepartmentService departmentService;
    private WardService wardService;
    private PatientService patientService;
      private StaffMemberService staffMemberService;
    
    @Autowired
    private DepartmentResourceAssembler departmentResourceAssembler;
     private WardResourceAssembler wardResourceAssembler;
     
      private StaffMemberResourceAssembler staffMemberResourceAssembler;
       private PatientResourceAssembler patientResourceAssembler;
    
   
    @RequestMapping(method = RequestMethod.GET) 
    ResponseEntity<List<DepartmentResource>> getDepartments() {   
        List<Department> d = departmentService.getDepartment();   
        List<DepartmentResource> resourceList = departmentResourceAssembler.toResources(d);  
        return new ResponseEntity<List<DepartmentResource>>(resourceList, HttpStatus.OK);  
    } 
    @RequestMapping("viewWard")
    ResponseEntity<List<WardResource>> getWard() {   
        List<Ward> w = wardService.getWard();   
        List<WardResource> resourceList = wardResourceAssembler.toResources(w);  
        return new ResponseEntity<List<WardResource>>(resourceList, HttpStatus.OK);  
    } 
    
     @RequestMapping("viewStaffMember")
    ResponseEntity<List<StaffMemberResource>> getStaffMember() {   
        List<StaffMember> p = staffMemberService.getStaffMember();   
        List<StaffMemberResource> resourceList = staffMemberResourceAssembler.toResources(p);  
        return new ResponseEntity<List<StaffMemberResource>>(resourceList, HttpStatus.OK);  
    } 
     @RequestMapping("viewPatient")
    ResponseEntity<List<PatientResource>>getPatient() {   
        List<Patient> p = patientService.getPatient();   
        List<PatientResource> resourceList = patientResourceAssembler.toResources(p);  
        return new ResponseEntity<List<PatientResource>>(resourceList, HttpStatus.OK);  
    } 
    
    
    @ExceptionHandler 
    ResponseEntity handleExceptions(Exception ex) {  
      ResponseEntity responseEntity = null;     
      responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);   
      return responseEntity;  
    } 
}
 