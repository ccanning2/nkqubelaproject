/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import java.util.List;

/**
 *
 * @author Hospital Management
 */
public interface Service<T, ID> {

    public T findById(final ID id);

    public List< T> findAll();

    public void persist(final T entity);

    public void merge(final T entity);

    public void remove(final T entity);

    public void removeById(final Long entityId);

    public List<T> findInRange(int firstResult, int maxResults);

    public long count();

    public T getByPropertyName(String name, String value);

    public List<T> getEntitiesByPropertyName(String name, String value);
}
