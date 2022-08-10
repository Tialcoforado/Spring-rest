package br.com.bb.exemplo.springdemo.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
    private final String externalClientUri;
    private final RestTemplate restTemplate;
//    external-cliente.users.api

    public UserClient(@Value("${external-cliente.users.api}") String externalClientUri, RestTemplate restTemplate) {
        this.externalClientUri = externalClientUri;
        this.restTemplate = restTemplate;
    }

    public ExternalUserList getAllExternalClients() {
        return this.restTemplate.getForEntity(externalClientUri, ExternalUserList.class).getBody();
    }

}
