package com.service2.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.service2.model.Address;
import com.service2.model.dto.DtoInput;
import com.service2.model.dto.DtoOutput;
import com.service2.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressServiceImpl implements SaveAddress {

    //Gọi đến discoverServer để lấy địa chỉ applicationServices cần tiêm
    @Autowired
    private EurekaClient eurekaClient;
    //Gọi đến endpoint của applicationServices cần có RestTemplate nên tiêm
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private AddressRepo addressRepo;

    @Override
    public String saveAddress(DtoInput dtoInput) {

        DtoOutput dtoOutput = new DtoOutput();
        dtoOutput.setNumberCard(dtoInput.getNumberCard());
        dtoOutput.setIssuedBy(dtoInput.getIssuedBy());

        String statusCode ="";

        //Gọi đến discoveryServer thông qua eurekaClient
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
        //Lấy Url để gọi đến Service
        String url = instanceInfo.getHomePageUrl() + "/service3";
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(dtoOutput), String.class);
        statusCode+=responseEntity.getStatusCode();
        if (statusCode.equals("200 OK")){
            Address address=new Address();
            address.setCountry(dtoInput.getCountry());
            address.setAddress(dtoInput.getAddress());
            addressRepo.save(address);
        }
        return  statusCode;
    }


}