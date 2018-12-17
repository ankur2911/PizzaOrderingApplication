package ToppingManagement;


public class ToppingService {
private ToppingDAO toppingDao;
	
	public ToppingService() {
		toppingDao = new ToppingDAO();
    }
	
	public boolean addTopping(ToppingEntity toppingEntity) {
        return toppingDao.addTopping(toppingEntity);
    }
}
