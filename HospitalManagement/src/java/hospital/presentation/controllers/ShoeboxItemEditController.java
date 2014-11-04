package hospital.presentation.controllers;


import hospital.app.facade.Facade;
import hospital.app.factory.AppFactory;
import hospital.model.entities.ShoeboxItem;
import hospital.presentation.controllers.validators.ShoeboxItemValidator;
import hospital.presentation.models.ShoeboxItemModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

@Controller
@MultipartConfig
public class ShoeboxItemEditController{ 
    @Resource(name = "shoeboxItemValidator")
    private ShoeboxItemValidator shoeboxItemValidator;
    private final Facade data = new Facade();
    private static final String SAVE_DIR = "resources/images";
    private static long id;
    
    @RequestMapping(value = "/addShoeboxItem.html", method = RequestMethod.GET)
    public String addShoeboxItem(Model model){
        ShoeboxItemModel shoeboxItemModel = new ShoeboxItemModel();
        shoeboxItemModel.setEstimatedPrice(BigDecimal.valueOf(9999));
        
        model.addAttribute("shoeboxItemModel", shoeboxItemModel);      

        return "hospital/addShoeboxItem";
    }
    
    @RequestMapping(value = "/editShoeboxItem.html", method = RequestMethod.GET)
    public String editShoeboxItem(HttpServletRequest req, Model model) throws ServletRequestBindingException{
        id = ServletRequestUtils.getLongParameter(req,"pk", -6);
        ShoeboxItemModel shoeboxItemModel = new ShoeboxItemModel();
        ShoeboxItem shoeboxItem;
        
        shoeboxItem = data.getShoeboxItemCrudService().findById(id);

        shoeboxItemModel.setEstimatedPrice(shoeboxItem.getEstimatedPrice());
        shoeboxItemModel.setImageUrl(shoeboxItem.getImageUrl());
        shoeboxItemModel.setItemDescription(shoeboxItem.getItemDescription());
        shoeboxItemModel.setItemName(shoeboxItem.getItemName());
        
        model.addAttribute("shoeboxItemModel", shoeboxItemModel);
        
        return "hospital/editShoeboxItem";
    }
    
    @RequestMapping(value = "/mergeShoeboxItem.php", method = RequestMethod.POST)
    public String mergeShoeboxItem(ShoeboxItemModel shoeboxItemModel, BindingResult result, HttpServletRequest req){        
        ShoeboxItem shoeboxItem = data.getShoeboxItemCrudService().findById(id);
        
        shoeboxItem.setEstimatedPrice(shoeboxItemModel.getEstimatedPrice());
        shoeboxItem.setImageUrl(shoeboxItemModel.getImageUrl());
        shoeboxItem.setItemDescription(shoeboxItemModel.getItemDescription());
        shoeboxItem.setItemName(shoeboxItemModel.getItemName());
        
        shoeboxItemValidator.validate(shoeboxItem, result);
        
        //if(containsErrors() == true){
            data.getShoeboxItemCrudService().merge(shoeboxItem);

            return "hospital/editShoeboxItem";
        //}else{
        //  return "hospital/viewShoeboxItems";
        //}
    } 
    
    @RequestMapping(value = "/persistShoeboxItem.php", method = RequestMethod.POST)
    public String persistShoeboxItem(ShoeboxItemModel shoeboxItemModel, HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "imageData", required = false) MultipartFile imageData) throws IOException{
        Map<String, String> stringValues = new HashMap<String, String>();
        
        stringValues.put("itemName", shoeboxItemModel.getItemName());
        stringValues.put("itemDescription", shoeboxItemModel.getItemDescription());
        stringValues.put("imageUrl", "resources/shoeboxitems/" + imageData.getOriginalFilename());
        
        File folder = new File("C:\\Users\\Chris\\Documents\\NetBeansProjects\\nkqubelaproject\\HospitalManagement\\web\\resources\\shoeboxitems");
        String filename = FilenameUtils.getBaseName(imageData.getName()); 
        String extension = FilenameUtils.getExtension(imageData.getName());
        File file = File.createTempFile(filename + "-", "." + extension, folder);
        
        System.out.println("Uploaded file successfully saved in " + file.getAbsolutePath());
        
        FileOutputStream fos = new FileOutputStream(new File("C:\\Users\\Chris\\Documents\\NetBeansProjects\\nkqubelaproject\\HospitalManagement\\web\\resources\\shoeboxitems\\" + imageData.getOriginalFilename()));                                
        fos.write(imageData.getBytes());
        fos.close();
        
        this.data.getShoeboxItemCrudService().persist(AppFactory.getShoeboxItem(stringValues, shoeboxItemModel.getEstimatedPrice()));

        return "hospital/result";
    }
}