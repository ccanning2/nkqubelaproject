/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.repository;

import java.io.Serializable;

/**
 *
 * @author Hospital Management
 */

public interface GenericDAO <T extends Serializable> extends DAO<T, Long>
{
	void setClass(final Class<T> classToSet);
}

