package com.tex.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "spring.cloud.config.enabled=false",
        
})
class TexapiApplicationTests {

	@Test
	void contextLoads() {
	}

}
