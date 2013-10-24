/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation.models;

import java.text.ParseException;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Enzo
 */
public class PatientModel {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String nickName;
    private long bedNumber;   
    private long medicalAidNumber;
    private String medicalAidName;
    private String medicalAidScheme;
    private long patientNumber;
    private String reasonForStay;
    private String emailAddress;
    private String contactNumber;
    private String race;
    private String gender;
    private String title;
    private String identityNumber;
    private String currentCondition;
    private Boolean hasMedicalAid;
    
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date dateOfArrival;
    
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date dateOfBirth;
    
    @DateTimeFormat(pattern="yyyy-mm-dd")
    private Date estimatedDateOfDeparture;

    public Date getEstimatedDateOfDeparture() {
        return estimatedDateOfDeparture;
    }

    public void setEstimatedDateOfDeparture(Date estimatedDateOfDeparture) {
        this.estimatedDateOfDeparture = estimatedDateOfDeparture;
    }

    public Boolean getHasMedicalAid() {
        return hasMedicalAid;
    }

    public void setHasMedicalAid(Boolean hasMedicalAid) {
        this.hasMedicalAid = hasMedicalAid;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(long bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Date getDateOfArrival() throws ParseException {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) throws ParseException {        
        this.dateOfArrival = dateOfArrival;
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

    public long getMedicalAidNumber() {
        return medicalAidNumber;
    }

    public void setMedicalAidNumber(long medicalAidNumber) {
        this.medicalAidNumber = medicalAidNumber;
    }

    public String getMedicalAidName() {
        return medicalAidName;
    }

    public void setMedicalAidName(String medicalAidName) {
        this.medicalAidName = medicalAidName;
    }

    public String getMedicalAidScheme() {
        return medicalAidScheme;
    }

    public void setMedicalAidScheme(String medicalAidScheme) {
        this.medicalAidScheme = medicalAidScheme;
    }
}