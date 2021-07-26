package com.cicoria.azurespringkeyvault.controllers;


import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetSecretController {

    @Value("${foobar}")
    private String mySecretProperty;

    @GetMapping("/")
    public String index(){

        return "you might have a secret: " + mySecretProperty;
    }

    private String getSecret(String key){
        SecretClient client = new SecretClientBuilder().buildClient();

        KeyVaultSecret secret = client.getSecret(key);

        return secret.getValue();
    }
}
