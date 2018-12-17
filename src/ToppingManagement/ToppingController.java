package ToppingManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OrderManagement.OrderEntity;
import OrderManagement.OrderService;

/**
 * Servlet implementation class ToppingController
 */
@WebServlet("/ToppingController")
public class ToppingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToppingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside Get Topping Controller");
		ToppingEntity te = new ToppingEntity();
		String result="";
		try {
			
			
			te.setTopping(request.getParameter("topping"));
			te.setQuantity(Integer.parseInt(request.getParameter("quantity")));

			
			 ToppingService toppingService = new ToppingService();
		        boolean addTopping = toppingService.addTopping(te);
		       
		     System.out.println(addTopping);
		     if(addTopping) {
		    	 	result = "Topping Added successfully!";
		 				 		
		     }
		     else {
		    	 result = "Some error has occurred, please try again later!";
		     }
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
