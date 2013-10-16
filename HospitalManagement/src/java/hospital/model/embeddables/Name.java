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
public class Name implements Serializable{
    private String firstName;
    private String middleName;
    private String lastName;
    private String nickName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }    
}
