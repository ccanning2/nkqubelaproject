/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.StaffMember;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author Enzo
 */
@Component
public class StaffMemberResourceAssembler extends ResourceAssemblerSupport<StaffMember, StaffMemberResource>{

    public StaffMemberResourceAssembler(){
        super(RESTController.class, StaffMemberResource.class);
    }
    @Override
    public StaffMemberResource toResource(StaffMember s) {
        StaffMemberResource r = instantiateResource(s);
        r.staffMember = s;
        r.add(linkTo(RESTController.class).slash(s.getId()).withSelfRel());
        return r;
    }
    
    @Override
    protected StaffMemberResource instantiateResource(StaffMember p)
    {
        return new StaffMemberResource(p);
    }
    
}
