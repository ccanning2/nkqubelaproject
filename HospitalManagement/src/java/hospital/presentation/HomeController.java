/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.presentation;

import hospital.app.facade.Facade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Chris
 */

@Controller
public class HomeController {
    private final Facade data = new Facade();

    @RequestMapping({"/"})
    public String home(Model model){        
        return "index";
    }
    
    @RequestMapping({"/login"})
    public String login(Model model){        
        return "login";
    }
    
    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {
            model.addAttribute("error", "true");
            return "login";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(Model model){
            return "login";
    }

    @RequestMapping(value = "/about.html", method = RequestMethod.GET)
    public String getAbout(Model model){
        return "about/about";
    }
    
    @RequestMapping(value = "/accessDenied.html", method = RequestMethod.GET)
    public String getAccess(Model model){
        return "accessDenied";
    }
}
