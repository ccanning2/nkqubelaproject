/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Ward;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author GizelleHeunis
 */
public class WardResource extends ResourceSupport {
    
    public Ward ward;

    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public WardResource(Ward ward) {
        this.ward = ward;
    }

    public WardResource() {
    }
}
