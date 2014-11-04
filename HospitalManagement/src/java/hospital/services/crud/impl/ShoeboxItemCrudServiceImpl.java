package hospital.services.crud.impl;

import hospital.model.entities.ShoeboxItem;
import hospital.repository.GenericDAO;
import hospital.services.crud.ShoeboxItemCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

@Service("shoeboxItemCrudService")
@Transactional
public class ShoeboxItemCrudServiceImpl implements ShoeboxItemCrudService {

    @Autowired
    private GenericDAO<ShoeboxItem> dao;

    public final void setDao(final GenericDAO<ShoeboxItem> daoToSet){
        this.dao = daoToSet;
        this.dao.setClass(ShoeboxItem.class);
    }

    public ShoeboxItemCrudServiceImpl(){
    }
    
    @Override
    public ShoeboxItem findById(Long id){
        setDao(dao);
        return dao.findById(id);
    }
    
    @Override
    public List<ShoeboxItem> findAll(){
        setDao(dao);
        return dao.findAll();
    }

    @Override
    public void persist(ShoeboxItem entity){
        setDao(dao);
        dao.persist(entity);
    }

    @Override
    public void merge(ShoeboxItem entity){
        setDao(dao);
        dao.merge(entity);
    }

    @Override
    public void remove(ShoeboxItem entity){
        setDao(dao);
        dao.remove(entity);
    }

    @Override
    public void removeById(Long entityId){
        setDao(dao);
        ShoeboxItem v = dao.findById(entityId);
        dao.remove(v);
    }

    @Override
    public List<ShoeboxItem> findInRange(int firstResult, int maxResults){
        setDao(dao);
        return dao.findInRange(firstResult, maxResults);
    }
    
    @Override
    public long count(){
        setDao(dao);
        return dao.count();
    }
    
    @Override
    public ShoeboxItem getByPropertyName(String name, String value){
        setDao(dao);
        return dao.getByPropertyName(name, value);
    }

    @Override
    public List<ShoeboxItem> getEntitiesByPropertyName(String name, String value) {
        setDao(dao);
        return dao.getEntitiesByPropertyName(name, value);
    }
}