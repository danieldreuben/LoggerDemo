package com.threadcontextex.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import java.util.Map;
import com.threadcontextex.demo.ExtLogger;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	private static final Logger logger = LogManager.getLogger(DemoApplication.class);

	private static final ExtLogger extended = ExtLogger.create(DemoApplication.class);

	@Test
	public void contextLoads() {
	}

	@Test
	public void loggingTests() {
		Map<String,String> mapCtx = Map.of("item", "shirt", "color", "blue","size","medium");
		ThreadContext.putAll(mapCtx);

		ThreadContext.put("item-1","testing123");
    	ThreadContext.put("item-2","testing345");
    	ThreadContext.push("single");
        
        logger.debug("Test:This is a debug message");
        logger.info("Test:This is an info message");
        logger.warn("Test:This is a warn message");
        logger.error("Test:This is an error message");    
	}

	@Test
	public void loggerTest() {
		extended.notice("this message will output with the notice logging level");

	}

}
