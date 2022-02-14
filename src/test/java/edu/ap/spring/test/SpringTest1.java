package edu.ap.spring.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest

public class SpringTest1 {
    
    @Test
    public void test1() throws Exception{
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        ResponseEntity<String> response1 = testRestTemplate.getForEntity("http://localhost:8080/balance/walletA", String.class);
        ResponseEntity<String> response2 = testRestTemplate.getForEntity("http://localhost:8080/balance/walletB", String.class);

        assertTrue(response1.getBody().contains("100.0"));
        assertTrue(response2.getBody().contains("0.0"));
    }

    @Test
    public void test2() throws Exception{
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("wallet1", "walletA");
        map.add("wallet2", "walletB");
        map.add("amount", "30.0");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        testRestTemplate.postForEntity("http://localhost:8080/transation", request, String.class);

        ResponseEntity<String> response1 = testRestTemplate.getForEntity("http://localhost:8080/balance/walletA", String.class);
        ResponseEntity<String> response2 = testRestTemplate.getForEntity("http://localhost:8080/balance/walletB", String.class);

        assertTrue(response1.getBody().contains("70.0"));
        assertTrue(response2.getBody().contains("30.0"));
    }
}
