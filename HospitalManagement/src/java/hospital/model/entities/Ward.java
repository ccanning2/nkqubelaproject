/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.entities;

import hospital.model.embeddables.Contact;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Hospital Management
 */

@Entity
public class Ward implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="patient_id")
    private List<Patient> patients;
    
    private String name;
    private Integer wardNumber;
    private Integer floorNumber;
    private String visitingHoursStart;
    private String visitingHoursEnd;

    @Embedded
    private Contact contact;
    
    @OneToOne
    private Person personInCharge;    
    
    public String getVisitingHoursStart() {
        return visitingHoursStart;
    }

    public void setVisitingHoursStart(String visitingHoursStart) {
        this.visitingHoursStart = visitingHoursStart;
    }

    public String getVisitingHoursEnd() {
        return visitingHoursEnd;
    }

    public void setVisitingHoursEnd(String visitingHoursEnd) {
        this.visitingHoursEnd = visitingHoursEnd;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Integer getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Person getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(Person personInCharge) {
        this.personInCharge = personInCharge;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
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
        if (!(object instanceof Ward)) {
            return false;
        }
        Ward other = (Ward) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital.Ward[ id=" + id + " ]";
    }
    
}
