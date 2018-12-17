package InventoryManagement;


public class InventoryService {
private InventoryDAO inventoryrDao;
	
	public InventoryService() {
		inventoryrDao = new InventoryDAO();
    }
	
	public boolean updateTopping(InventoryEntity inventoryEntity) {
        return inventoryrDao.updateTopping(inventoryEntity);
    }
	
	public boolean deleteTopping(InventoryEntity inventoryEntity) {
        return inventoryrDao.deleteTopping(inventoryEntity);
    }
	
}
