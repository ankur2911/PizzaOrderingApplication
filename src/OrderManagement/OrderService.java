package OrderManagement;


public class OrderService {
	
	private OrderDao orderDao;
	
	public OrderService() {
		orderDao = new OrderDao();
    }
	
	public boolean orderPizza(OrderEntity orderEntity) {
        return orderDao.orderPizza(orderEntity);
    }
	
	public void decTopping(String topping) {
		orderDao.decTopping(topping);
	}
	
}
