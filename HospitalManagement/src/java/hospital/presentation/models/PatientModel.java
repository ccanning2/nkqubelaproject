/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.models;

import java.util.Date;

/**
 *
 * @author Enzo
 */
public class PatientModel {
   private Long id;
   private String name;
   private long bedNumber;
   private Date dateOfArrival;
   private int medicalAidID;
   private long patientNumber;
   private String reasonForStay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(long bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public int getMedicalAidID() {
        return medicalAidID;
    }

    public void setMedicalAidID(int medicalAidID) {
        this.medicalAidID = medicalAidID;
    }

    public long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(long patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getReasonForStay() {
        return reasonForStay;
    }

    public void setReasonForStay(String reasonForStay) {
        this.reasonForStay = reasonForStay;
    }
   
}

    