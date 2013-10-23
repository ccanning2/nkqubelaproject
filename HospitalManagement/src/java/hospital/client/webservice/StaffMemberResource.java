/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.StaffMember;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Enzo
 */
public class StaffMemberResource extends ResourceSupport {
    
    public StaffMember staffMember;

    public StaffMember getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public StaffMemberResource(StaffMember staffMember) {
        this.staffMember = staffMember;
    }

    public StaffMemberResource() {
    }
}
