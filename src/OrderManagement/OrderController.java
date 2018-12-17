package OrderManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderController
 */
@WebServlet("/OrderController")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Get Order Controller");
		OrderEntity oe = new OrderEntity();
		String result="";
		try {
			String toppings = request.getParameter("toppings");
			String[] toppingList = (toppings.trim()).split(" ");
			
			int cost = 5;
			if(toppings!="" && toppings!=null) {
				cost=cost+toppingList.length;
			}
			
			System.out.println("list:"+toppingList.length);
			toppings = toppings.trim().replaceAll(" ", ",");
			oe.setEmail(request.getParameter("email"));
			oe.setName(request.getParameter("name"));
			oe.setSize(request.getParameter("size"));
			oe.setCrust(request.getParameter("crust"));
			oe.setToppings(toppings);
			oe.setInfo(request.getParameter("info"));
			oe.setCost(cost);
			
			 OrderService orderService = new OrderService();
		        boolean orderPizza = orderService.orderPizza(oe);
		       
		     if(orderPizza) {
		    	 
		    	 	for(String str: toppingList) {
		    	 		orderService.decTopping(str);
		    	 	}
		    	 	result = "Order placed! The total cost is: $"+ cost;
		 		
		 		
		 		
		     }else {
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
		
		
	}

}
