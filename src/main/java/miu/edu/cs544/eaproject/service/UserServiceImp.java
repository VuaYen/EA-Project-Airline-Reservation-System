//package miu.edu.cs544.eaproject.service;
//
//import miu.edu.cs544.eaproject.service.response.UserResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Service
//public class UserServiceImp implements UserService {
//
//    private static final String AUTH_SERVICE_URL = "http://127.0.0.1:8080";
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Override
//    public UserResponse getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserResponse userResponse = restTemplate.getForObject(AUTH_SERVICE_URL+"/accounts/get-by-username/"+authentication.getName(), UserResponse.class);
//        return userResponse;
//    }
//}
