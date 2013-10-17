/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Department;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author GizelleHeunis
 */
@Component
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource>{

    public DepartmentResourceAssembler(){
        super(RESTController.class, DepartmentResource.class);
    }
    @Override
    public DepartmentResource toResource(Department d) {
        DepartmentResource r = instantiateResource(d);
        r.department = d;
        r.add(linkTo(RESTController.class).slash(d.getId()).withSelfRel());
        return r;
    }
    
    @Override
    protected DepartmentResource instantiateResource(Department d)
    {
        return new DepartmentResource(d);
    }
    
}
