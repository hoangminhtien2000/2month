package com.service1.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.service1.conmon.ValidateInput;
import com.service1.model.Student;
import com.service1.model.dto.DtoInput;
import com.service1.model.dto.DtoOutput;
import com.service1.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements SendAddress {

    @Autowired
    private StudentRepo studentRepo;
    //Gọi đến discoverServer để lấy địa chỉ applicationServices cần tiêm
    @Autowired
    private EurekaClient eurekaClient;
    //Gọi đến endpoint của applicationServices cần có RestTemplate nên tiêm
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private ValidateInput validateInput;



    @Override
    public String sendAddress(DtoInput dtoInput) {
        String message = "";

        final String name = dtoInput.getName();
        boolean name1 = Pattern.matches(validateInput.names, name);
        if (!name1) {
            message += validateInput.errorName;
        }
        final String age = dtoInput.getAge();
        boolean age1 = Pattern.matches(validateInput.age, age);
        if (!age1) {
            message += validateInput.errorAge;
        }
        final String gender = dtoInput.getGender();
        boolean gender1 = Pattern.matches(validateInput.gender, gender);
        if (!gender1) {
            message += validateInput.errorGender;
        }

        final String country = dtoInput.getCountry();
        boolean country1 = Pattern.matches(validateInput.country, country);
        if (!country1) {
            message += validateInput.errorCountry;
        }
        final String address = dtoInput.getAddress();
        boolean address1 = Pattern.matches(validateInput.address, address);
        if (!address1) {
            message += validateInput.errorAddress;
        }
        final String numberCard = dtoInput.getNumberCard();
        boolean numberCard1 = Pattern.matches(validateInput.numberCard, numberCard);
        if (!numberCard1) {
            message += validateInput.errorNumberCard;
        }
        final String issuedBy = dtoInput.getIssuedBy();
        boolean issuedBy1 = Pattern.matches(validateInput.issuedBy, issuedBy);
        if (!issuedBy1) {
            message += validateInput.errorIssuedBy;
        }


        String statusCode = "";
        String messageService3 = "";
        boolean messageAddress = Pattern.matches(validateInput.messageOutput, message);
        if (messageAddress) {
            DtoOutput dtoOutput = new DtoOutput();
            dtoOutput.setCountry(country);
            dtoOutput.setAddress(address);
            dtoOutput.setNumberCard(numberCard);
            dtoOutput.setIssuedBy(issuedBy);

            //Gọi đến discoveryServer thông qua eurekaClient
            InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("gateway-service", false);
            //Lấy Url để gọi đến Service
            String url = instanceInfo.getHomePageUrl() + "/service2/receiver";
            RestTemplate restTemplate = restTemplateBuilder.build();
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(dtoOutput), String.class);
            statusCode += responseEntity.getStatusCode();
            messageService3 = responseEntity.getBody();
        }
        boolean statusCode1 = Pattern.matches(validateInput.statusCode, statusCode);
        boolean checkMessage = Pattern.matches(validateInput.checkMessage, message);
        if (!statusCode1 && checkMessage && messageService3.equals("200 OK")) {
            Student student = new Student();
            message += validateInput.successStudent;
            message += validateInput.successAddress;
            message += validateInput.successIDCard;
            student.setName(name);
            student.setAge(Integer.parseInt(age));
            student.setGender(gender);
            studentRepo.save(student);
        }

        return message;


    }

}