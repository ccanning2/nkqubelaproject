package hospital.services;

import hospital.model.entities.ShoeboxItem;
import java.util.List;

/**
 *
 * @author Chris Canning
 * @version 1.0
 */

public interface ShoeboxItemService {
    public List<ShoeboxItem> getShoeboxItems();
    public ShoeboxItem getShoeboxItem(final long itemID);
}