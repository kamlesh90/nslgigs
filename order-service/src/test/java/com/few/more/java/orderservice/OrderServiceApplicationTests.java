package com.few.more.java.orderservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
class OrderServiceApplicationTests {

	@Test
	void shouldPlaceOrder() {
		
		//static MySQLContainer<MySQLContainer<SELF>> mysqlCont = new MySQLContainer<>("")
	}

}
