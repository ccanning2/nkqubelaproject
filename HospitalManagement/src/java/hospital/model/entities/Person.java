/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.entities;

import hospital.model.embeddables.Name;
import hospital.model.embeddables.Demographic;
import hospital.model.embeddables.Contact;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Hospital Management
 */

@Entity
public class Person implements Serializable{   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    private Name name;
    
    @Embedded
    private Contact contact;
    
    @Embedded
    private Demographic demographic;
    
    private String identityNumber;

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

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }
    
    public String getFullName(){
        return this.name.getFirstName() + " " + this.name.getLastName();
    }
        public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital.Person[ id=" + id + " ]";
    }
}
