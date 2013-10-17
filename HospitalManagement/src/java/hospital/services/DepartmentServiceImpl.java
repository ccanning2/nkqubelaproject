/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import hospital.model.entities.Department;
import hospital.services.crud.DepartmentCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/**
 *
 * @author GizelleHeunis
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentCrudService departmentCrudService;
    
  //  private static ApplicationContext ctx;
    
    @Override
    public List<Department> getDepartment()
    {
       // ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-*.xml");
        //departmentCrudService = (DepartmentCrudService)ctx.getBean("departmentCrudService");
        
        return departmentCrudService.findAll();
    }
            
}
    
