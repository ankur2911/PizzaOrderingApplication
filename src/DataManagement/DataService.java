package DataManagement;

import java.util.HashMap;

public class DataService {

	private DataDAO dataDAO;
	
	public DataService() {
		dataDAO = new DataDAO();
	}
	
	public HashMap<String,Integer> getData(){
		return dataDAO.getData();
	}
}
