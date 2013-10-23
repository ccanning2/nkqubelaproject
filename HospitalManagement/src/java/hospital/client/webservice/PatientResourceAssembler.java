/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Department;
import hospital.model.entities.Patient;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 *
 * @author Enzo
 */
@Component
public class PatientResourceAssembler extends ResourceAssemblerSupport<Patient, PatientResource>{

    public PatientResourceAssembler(){
        super(RESTController.class, PatientResource.class);
    }
    @Override
    public PatientResource toResource(Patient p) {
        PatientResource r = instantiateResource(p);
        r.patient = p;
        r.add(linkTo(RESTController.class).slash(p.getId()).withSelfRel());
        return r;
    }
    
    @Override
    protected PatientResource instantiateResource(Patient p)
    {
        return new PatientResource(p);
    }
    
}
