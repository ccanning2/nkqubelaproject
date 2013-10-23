/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Ward;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author GizelleHeunis
 */
@Component
public class WardResourceAssembler extends ResourceAssemblerSupport<Ward, WardResource>{

    public WardResourceAssembler(){
        super(RESTController.class, WardResource.class);
    }
    @Override
    public WardResource toResource(Ward d) {
        WardResource r = instantiateResource(d);
        r.ward = d;
        r.add(linkTo(RESTController.class).slash(d.getId()).withSelfRel());
        return r;
    }
    
    @Override
    protected WardResource instantiateResource(Ward d)
    {
        return new WardResource(d);
    }
    
}
