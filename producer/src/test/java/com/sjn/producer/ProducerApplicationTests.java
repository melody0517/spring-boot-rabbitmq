package com.sjn.producer;

import com.sjn.producer.component.ProducerMessage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ProducerApplicationTests {

	@Autowired
	private ProducerMessage producerMessage;

	@Test
	void sendMsg() throws InterruptedException {
		producerMessage.sendMsg("hello");
		new CountDownLatch(1).await();
	}

}
