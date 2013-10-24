/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services.crud.impl;

import hospital.model.entities.MedicalAid;
import hospital.repository.GenericDAO;
import hospital.services.crud.MedicalAidCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hospital Management
 */
@Service("medicalAidCrudService")
@Transactional
public class MedicalAidCrudServiceImpl implements MedicalAidCrudService {

    @Autowired
    private GenericDAO<MedicalAid> dao;

    public final void setDao(final GenericDAO<MedicalAid> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClass(MedicalAid.class);
    }

    public MedicalAidCrudServiceImpl() {
    }
    
    @Override
    public MedicalAid findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<MedicalAid> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(MedicalAid entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(MedicalAid entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(MedicalAid entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        MedicalAid v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<MedicalAid> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    
    @Override
    public MedicalAid getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<MedicalAid> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}

