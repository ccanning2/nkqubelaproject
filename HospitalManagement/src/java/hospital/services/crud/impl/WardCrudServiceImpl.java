/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services.crud.impl;

import hospital.model.entities.Ward;
import hospital.repository.GenericDAO;
import hospital.services.crud.WardCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hospital Management
 */
@Service("wardCrudService")
@Transactional
public class WardCrudServiceImpl implements WardCrudService {

    @Autowired
    private GenericDAO<Ward> dao;

    public final void setDao(final GenericDAO<Ward> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClass(Ward.class);
    }

    public WardCrudServiceImpl() {
    }
    
    @Override
    public Ward findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Ward> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Ward entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Ward entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Ward entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Ward w = dao.findById(entityId);
        dao.remove(w);
    }

    @Override
    public List<Ward> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Ward getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Ward> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}

