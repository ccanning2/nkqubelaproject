/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.model.embeddables;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Hospital Management
 */

@Embeddable
public class Contact implements Serializable{
    private String contactNumber;
    private String emailAddress;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
