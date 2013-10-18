/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services.crud.impl;

import hospital.model.entities.Users;
import hospital.repository.GenericDAO;
import hospital.services.crud.UserCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris
 */
@Service("userCrudService")
@Transactional
public class UserCrudServiceImpl implements UserCrudService {

    @Autowired
    private GenericDAO<Users> dao;

    public final void setDao(final GenericDAO<Users> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClass(Users.class);
    }

    public UserCrudServiceImpl() {
    }
    
    @Override
    public Users findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Users> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Users entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Users entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Users entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Users v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Users> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Users getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Users> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}

