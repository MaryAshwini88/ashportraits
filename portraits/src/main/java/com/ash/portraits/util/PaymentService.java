package com.ash.portraits.util;

import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PaymentService {
  @Value("${razorpay.keyId}")
  private String keyId;
  
  @Value("${razorpay.keySecret}")
  private String keySecret;
  
  @Bean
  public RazorpayClient razorpayClient() throws Exception {
    return new RazorpayClient(keyId, keySecret);
  }
}