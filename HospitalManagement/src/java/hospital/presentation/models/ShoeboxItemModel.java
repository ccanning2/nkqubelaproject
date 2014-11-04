package hospital.presentation.models;

import java.math.BigDecimal;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author Chris
 */

public class ShoeboxItemModel {
    private long id;
    private String itemName;
    private String itemDescription;
    private BigDecimal estimatedPrice;
    private String imageUrl;
    private MultipartFile imageData;
    
    public ShoeboxItemModel(){
    }

    public MultipartFile getImageData() {
        return imageData;
    }

    public void setImageData(MultipartFile imageData) {
        System.out.println("imageData: " + imageData);
        
        this.imageData = imageData;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public BigDecimal getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(BigDecimal estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}