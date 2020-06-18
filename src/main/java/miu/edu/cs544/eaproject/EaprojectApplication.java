package miu.edu.cs544.eaproject;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableDiscoveryClient
//@ComponentScan({"miu.edu.cs544.eaproject.controller","miu.edu.cs544.eaproject.service","miu.edu.cs544.eaproject.repository"})
public class EaprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EaprojectApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    };

}
