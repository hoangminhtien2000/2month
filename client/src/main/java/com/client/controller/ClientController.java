package com.client.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    //Gọi đến discoverServer để lấy địa chỉ applicationServices cần tiêm
    @Autowired
    private EurekaClient eurekaClient;
    //Gọi đến endpoint của applicationServices cần có RestTemplate nên tiêm
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @RequestMapping("/service1")
    public String callService() {
        //Gọi đến discoverServer để lấy instance của service gọi thông qua eurekaClient
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service1", false);
        //Lấy Url để gọi đến Service
        String url = instanceInfo.getHomePageUrl()+"/service1/";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity= restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return responseEntity.getBody();
    }

    @PostMapping("/service1/{dem}")
    public String dem(@PathVariable int dem) {
        //Gọi đến discoverServer thông qua eurekaClient
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service1", false);
        //Lấy Url để gọi đến Service
        String url = instanceInfo.getHomePageUrl()+"/service1/"+dem;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity= restTemplate.exchange(url, HttpMethod.POST,  null, String.class);
        return responseEntity.getBody();
    }

    @PostMapping("/service2/{dem}")
    public String dem2(@PathVariable int dem) {
        //Gọi đến discoverServer thông qua eurekaClient
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service2", false);
        //Lấy Url để gọi đến Service
        String url = instanceInfo.getHomePageUrl()+"/service2/"+dem;
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity= restTemplate.exchange(url, HttpMethod.POST,  null, String.class);
        return responseEntity.getBody();
    }

}
