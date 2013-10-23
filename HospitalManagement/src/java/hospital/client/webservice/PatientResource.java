/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.client.webservice;

import hospital.model.entities.Patient;
import org.springframework.hateoas.ResourceSupport;

/**
 *
 * @author Enzo
 */
public class PatientResource extends ResourceSupport {
    
    public Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public PatientResource(Patient patient) {
        this.patient = patient;
    }

    public PatientResource() {
    }
}
