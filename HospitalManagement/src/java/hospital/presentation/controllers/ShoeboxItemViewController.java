package hospital.presentation.controllers;

import hospital.app.facade.Facade;
import hospital.model.entities.ShoeboxItem;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ShoeboxItemViewController { 
    private final Facade data = new Facade();
    private static long id;
  
    @RequestMapping(value = "/viewShoeboxItems.html", method = RequestMethod.GET)
    public String viewShoeboxItems(Model model){        
        List<ShoeboxItem> shoeboxItems = data.getShoeboxItemCrudService().findAll();
        
        model.addAttribute("shoeboxItems", shoeboxItems);
        
        return "hospital/viewShoeboxItems";
    }
    
    @RequestMapping(value = "/viewShoeboxItem.html", method = RequestMethod.GET)
    public String viewDepartment(HttpServletRequest req,Model model) throws ServletRequestBindingException{    
        long pk = ServletRequestUtils.getLongParameter(req,"pk", -6);
        ShoeboxItem shoeboxItem = data.getShoeboxItemCrudService().findById(pk);
        
        model.addAttribute("shoeboxItem", shoeboxItem);
        
        return "hospital/viewShoeboxItem";
    }
}