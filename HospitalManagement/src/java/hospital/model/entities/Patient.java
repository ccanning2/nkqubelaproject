/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Hospital Management
 */

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Patient extends Person implements Serializable {
    private Long patientNumber;
    private String currentCondition;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfArrival;    
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date estimatedDateOfDischarge;
    
    private String reasonForStay;
    private long bedNumber;
    
    @OneToOne
    private MedicalAid medicalAid;

    public long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(long patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Date getEstimatedDateOfArrival() {
        return estimatedDateOfDischarge;
    }

    public void setEstimatedDateOfArrival(Date estimatedDateOfArrival) {
        this.estimatedDateOfDischarge = estimatedDateOfArrival;
    }

    public String getReasonForStay() {
        return reasonForStay;
    }

    public void setReasonForStay(String reasonForStay) {
        this.reasonForStay = reasonForStay;
    }

    public long getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(long bedNumber) {
        this.bedNumber = bedNumber;
    }

    public MedicalAid getMedicalAid() {
        return medicalAid;
    }

    public void setMedicalAid(MedicalAid medicalAid) {
        this.medicalAid = medicalAid;
    }

    public Date getEstimatedDateOfDischarge() {
        return estimatedDateOfDischarge;
    }

    public void setEstimatedDateOfDischarge(Date estimatedDateOfDischarge) {
        this.estimatedDateOfDischarge = estimatedDateOfDischarge;
    }    
}
