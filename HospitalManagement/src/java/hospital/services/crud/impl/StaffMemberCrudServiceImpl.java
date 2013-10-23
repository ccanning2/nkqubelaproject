/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services.crud.impl;

import hospital.model.entities.Person;
import hospital.model.entities.StaffMember;
import hospital.repository.GenericDAO;
import hospital.services.crud.PersonCrudService;
import hospital.services.crud.StaffMemberCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hospital Management
 */
@Service("staffMemberCrudService")
@Transactional
public class StaffMemberCrudServiceImpl implements StaffMemberCrudService {

    @Autowired
    private GenericDAO<StaffMember> dao;

    public final void setDao(final GenericDAO<StaffMember> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClass(StaffMember.class);
    }

    public StaffMemberCrudServiceImpl() {
    }
    
    @Override
    public StaffMember findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<StaffMember> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(StaffMember entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(StaffMember entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(StaffMember entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        StaffMember v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<StaffMember> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    
    @Override
    public StaffMember getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<StaffMember> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}

