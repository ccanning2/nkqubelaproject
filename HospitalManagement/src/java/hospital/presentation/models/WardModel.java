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
    private String name;
    private Integer floorNumber;
    private Person personInCharge;
    private Integer wardNumber;
    private String emailAddress;
    private String contactNumber;
    private String visitingHoursStart;
    private String visitingHoursEnd;

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

    public Person getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(Person personInCharge) {
        this.personInCharge = personInCharge;
    }

    public Integer getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }
}