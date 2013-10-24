/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.models;

import hospital.model.entities.Person;


/**
 *
 * @author Gizelle
 */

public class WardModel
{
    private long id;
    private String name;
    private long department;
    private Integer floorNumber;
    private long personInCharge;
    private long wardNumber;
    private String emailAddress;
    private String contactNumber;
    private String visitingHoursStart;
    private String visitingHoursEnd;

    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

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

    public long getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(long personInCharge) {
        this.personInCharge = personInCharge;
    }

    public long getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(long wardNumber) {
        this.wardNumber = wardNumber;
    }
}