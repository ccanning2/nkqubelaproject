/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.models;

import hospital.model.entities.Patient;
import hospital.model.entities.Ward;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;


/**
 *
 * @author Gizelle
 */

public class WardModel
{
   private long patients;
   private String floorNumber;
   private String personInCharge;
   private Integer wardNumber;
   private Integer amountOfPatients;

    public long getPatients() {
        return patients;
    }

    public void setPatients(long patients) {
        this.patients = patients;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public Integer getWardNumber() {
        return wardNumber;
    }

    public void setWardNumber(Integer wardNumber) {
        this.wardNumber = wardNumber;
    }

    public Integer getAmountOfPatients() {
        return amountOfPatients;
    }

    public void setAmountOfPatients(Integer amountOfPatients) {
        this.amountOfPatients = amountOfPatients;
    }
 
}