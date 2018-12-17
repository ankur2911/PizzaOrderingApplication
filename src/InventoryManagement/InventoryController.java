package InventoryManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InventoryController
 */
@WebServlet("/InventoryController")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InventoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside Inventory Controller");
		String submitType = request.getParameter("submitType");
		InventoryEntity ie = new InventoryEntity();
		InventoryService inventoryService = new InventoryService();

		if(submitType.equalsIgnoreCase("update")) {
			ie.setTopping(request.getParameter("topping"));
			ie.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			
			boolean updateinventory = inventoryService.updateTopping(ie);
			
			String result = "";

			if(updateinventory) {
				result = "The topping has been updated!";
				
			}else {
				result = "There was a problem in updating the topping. Try again later!";
			}
			response.getWriter().append(result);
			
		}else if(submitType.equalsIgnoreCase("delete")) {
			
			ie.setTopping(request.getParameter("topping"));
			
			boolean deletetoppinginventory = inventoryService.deleteTopping(ie);
			
			String result = "";

			if(deletetoppinginventory) {
				result = "The topping has been deleted!";
				
			}else {
				result = "There was a problem in deleting the topping. Try again later!";
			}
			response.getWriter().append(result);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
