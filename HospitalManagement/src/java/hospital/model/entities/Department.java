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

/**
 *
 * @author Hospital Management
 */

@Entity
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Integer floorNumber;
    private String description;
    private Integer departmentSize;
    private Long personInCharge;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="staff_member_id")
    private List<StaffMember> staffMembers;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="ward_id")
    private List<Ward> wards;
    
    @Embedded
    private Contact contact; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDepartmentSize() {
        return departmentSize;
    }

    public void setDepartmentSize(Integer departmentSize) {
        this.departmentSize = departmentSize;
    }

    public Long getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(Long personInCharge) {
        this.personInCharge = personInCharge;
    }

    public List<StaffMember> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<StaffMember> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
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
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital.Department[ id=" + id + " ]";
    }    
}
