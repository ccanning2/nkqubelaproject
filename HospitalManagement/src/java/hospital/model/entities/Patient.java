/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Hospital Management
 */
@Entity
public class Patient extends Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    public Long getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(Long patientNumber) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEstimatedDateOfDischarge() {
        return estimatedDateOfDischarge;
    }

    public void setEstimatedDateOfDischarge(Date estimatedDateOfDischarge) {
        this.estimatedDateOfDischarge = estimatedDateOfDischarge;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hospital.Patient[ id=" + id + " ]";
    }
    
}
