//package com.ash.portraits.service;
//
//import java.util.Optional;
//
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//
//
//import com.ash.portraits.model.PortraitOrder;
//import com.ash.portraits.repository.PortraitOrderRepository;
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//
//public class PortraitsOrdersService {
//	
//	@Autowired
//	PortraitOrderRepository orderRepository;
//	
//	@Autowired
//    private RazorpayClient razorpayClient;
//	
//
//	
//    public ResponseEntity<String> createOrder(PortraitOrder portraitOrder) {
//        try {
//        	String result = createOrder(portraitOrder.getAmount(), "inr");
//        	portraitOrder.setTransactionStatus(result);
//        	orderRepository.save(portraitOrder);
//            return ResponseEntity.ok(result.toString());
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("Error creating payment order: " + e.getMessage());
//        }
//    }
//    
//    
//    public String createOrder(double amount, String currency) throws Exception {
//      JSONObject orderRequest = new JSONObject();
//      orderRequest.put("amount", amount * 100);
//      orderRequest.put("currency", currency);
//      orderRequest.put("payment_capture", 1);
//      Order order = razorpayClient.orders.create(orderRequest);
//      return order.toString();
//    }
//
//
//	public PortraitOrder fetchOrderById(String orderId) {
//    	Optional<PortraitOrder> order = orderRepository.findById(orderId);
//    	if (order.isPresent()) {
//    		return order.get();
//    	}
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
