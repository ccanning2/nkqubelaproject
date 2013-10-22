/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.entities;

import hospital.model.embeddables.Name;
import hospital.model.embeddables.Demographic;
import hospital.model.embeddables.Contact;
import java.io.Serializable;
import javax.persistence.Embedded;

/**
 *
 * @author Hospital Management
 */

public class Person implements Serializable{   
    @Embedded
    private Name name;
    
    @Embedded
    private Contact contact;
    
    @Embedded
    private Demographic demographic;
    
    private Long identityNumber;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Demographic getDemographic() {
        return demographic;
    }

    public void setDemographic(Demographic demographic) {
        this.demographic = demographic;
    }

    public Long getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(Long identityNumber) {
        this.identityNumber = identityNumber;
    }    
}
