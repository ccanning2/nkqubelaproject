package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.model.entities.ShoeboxItem;
import hospital.presentation.models.ShoeboxItemModel;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

@Controller
public class ShoeboxItemDeleteController { 
    private final Facade data = new Facade();
    private static long id;
    
    @RequestMapping(value = "/deleteShoeboxItem.html", method = RequestMethod.GET)
    public String deleteShoeboxItem(HttpServletRequest req, Model model) throws ServletRequestBindingException{
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);  
        ShoeboxItem shoeboxItem;
        
        shoeboxItem = data.getShoeboxItemCrudService().findById(pk);
        data.getShoeboxItemCrudService().remove(shoeboxItem);
        
        return "hospital/result";
    }

    @RequestMapping(value = "/removeShoeboxItem.php", method = RequestMethod.GET)
    public String removeShoeboxItem(ShoeboxItemModel shoeboxItemModel, BindingResult result, HttpServletRequest req){
        ShoeboxItem shoeboxItem = data.getShoeboxItemCrudService().findById(shoeboxItemModel.getId());

        data.getShoeboxItemCrudService().remove(shoeboxItem);
        
        return "hospital/result";
    }
}