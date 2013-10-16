/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.app.facade;

import hospital.app.config.GetContext;
import hospital.services.crud.DepartmentCrudService;

import java.io.Serializable;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author Hospital Management
 */
public class Facade implements Serializable {
    private final static ApplicationContext ctx = GetContext.getApplicationContext();
    private DepartmentCrudService departmentCrudService;    

    public DepartmentCrudService getDepartmentCrudService() {
        departmentCrudService = (DepartmentCrudService) ctx.getBean("departmentCrudService");
        return departmentCrudService;
    }
}
