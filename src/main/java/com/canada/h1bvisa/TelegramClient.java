package com.canada.h1bvisa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TelegramClient {
    private String token = "6782444501:AAGm-6HZFxZ8vZY286opOKKJPlJowRCZEmI";
    private String telegramBaseUrl = "https://api.telegram.org/bot";
    private String apiUrl = telegramBaseUrl+token;



    private static final Logger logger = LoggerFactory.getLogger(TelegramClient.class);


    public void sendMessage(String message, String chatID) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl+"/sendMessage")
                    .queryParam("chat_id", chatID)
                    .queryParam("text", message);
            ResponseEntity exchange = restTemplate.exchange(builder.toUriString().replaceAll("%20", " "), HttpMethod.GET, null, String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error response : State code: {}, response: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception err) {
            logger.error("Error: {} ", err.getMessage());
            throw new Exception("This service is not available at the moment!");
        }
    }
}
