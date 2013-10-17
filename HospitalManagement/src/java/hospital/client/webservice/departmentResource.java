/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Department;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author GizelleHeunis
 */
public class DepartmentResource extends ResourceSupport {
    
    public Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentResource(Department department) {
        this.department = department;
    }

    public DepartmentResource() {
    }
    
    
}
