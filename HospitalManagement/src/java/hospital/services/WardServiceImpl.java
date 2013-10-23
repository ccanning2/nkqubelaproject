/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import hospital.model.entities.Department;
import hospital.model.entities.Ward;
import hospital.services.crud.DepartmentCrudService;
import hospital.services.crud.WardCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/**
 *
 * @author GizelleHeunis
 */
@Service("wardService")
public class WardServiceImpl implements WardService {
    
    @Autowired
    private WardCrudService wardCrudService;
    
  //  private static ApplicationContext ctx;
    
    @Override
    public List<Ward> getWard()
    {
       // ctx = new ClassPathXmlApplicationContext("classpath:hospital/app/config/applicationContext-*.xml");
        //departmentCrudService = (DepartmentCrudService)ctx.getBean("departmentCrudService");
        
        return wardCrudService.findAll();
    }
            
}
    
