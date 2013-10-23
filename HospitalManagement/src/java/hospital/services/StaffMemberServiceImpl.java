/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import hospital.model.entities.Department;
import hospital.model.entities.StaffMember;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.StaffMemberCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/**
 *
 * @author Enzo
 */
@Service("staffMemberService")
public class StaffMemberServiceImpl implements StaffMemberService {
    
    @Autowired
    private StaffMemberCrudService staffMemberCrudService;
    
  //  private static ApplicationContext ctx;
    
    @Override
    public List<StaffMember> getStaffMember()
    {
       // ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-*.xml");
        //departmentCrudService = (DepartmentCrudService)ctx.getBean("departmentCrudService");
        
        return staffMemberCrudService.findAll();
    }
            
}
    
