package hospital.presentation.controllers.validators;

import hospital.model.entities.ShoeboxItem;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Chris
 */

public class ShoeboxItemValidator implements Validator {
    
    @Override
    public boolean supports(Class clazz) {
        return ShoeboxItem.class.isAssignableFrom(clazz);
    }
    
    @Override
    public void validate(Object target, Errors errors) {
        ShoeboxItem shoeboxItem = (ShoeboxItem)target;
        
        if(shoeboxItem.getItemName() == null || shoeboxItem.getItemName().trim().equals("")){            
            errors.rejectValue("itemName", "required.item.name", "Item Name cannot be empty!");
        }
        
        if(shoeboxItem.getItemDescription() == null || shoeboxItem.getItemDescription().trim().equals("")){            
            errors.rejectValue("itemDescription", "required.item.description", "Item Description cannot be empty!");
        }
        
        if(shoeboxItem.getEstimatedPrice() == null){            
            errors.rejectValue("estimatedPrice", "required.item.estimated.price", "Estimated Price cannot be empty!");
        }
    }
}