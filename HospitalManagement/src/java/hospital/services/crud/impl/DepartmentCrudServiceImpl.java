/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services.crud.impl;

import hospital.model.entities.Department;
import hospital.repository.GenericDAO;
import hospital.services.crud.DepartmentCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Hospital Management
 */
@Service("departmentCrudService")
@Transactional
public class DepartmentCrudServiceImpl implements DepartmentCrudService {

    @Autowired
    private GenericDAO<Department> dao;

    public final void setDao(final GenericDAO<Department> daoToSet) {
        this.dao = daoToSet;
        this.dao.setClass(Department.class);
    }

    public DepartmentCrudServiceImpl() {
    }
    
    @Override
    public Department findById(Long id) {
        setDao(dao);
        return dao.findById(id);
    }
    @Override
    public List<Department> findAll() {
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(Department entity) {
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(Department entity) {
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(Department entity) {
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId) {
        setDao(dao);
        Department v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<Department> findInRange(int firstResult, int maxResults) {
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);

    }
    @Override
    public long count() {
        setDao(dao);
        return dao.count();
    }
    @Override
    public Department getByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<Department> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}

