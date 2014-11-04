/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.services;

import hospital.model.entities.ShoeboxItem;
import hospital.services.crud.ShoeboxItemCrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

@Service("shoeboxItemService")
public class ShoeboxServiceImpl implements ShoeboxItemService {
    
    @Autowired
    private ShoeboxItemCrudService shoeboxItemCrudService;            

    @Override
    public List<ShoeboxItem> getShoeboxItems(){
        return this.shoeboxItemCrudService.findAll();
    }

    @Override
    public ShoeboxItem getShoeboxItem(final long itemID){
        return this.shoeboxItemCrudService.findById(itemID);
    }
}