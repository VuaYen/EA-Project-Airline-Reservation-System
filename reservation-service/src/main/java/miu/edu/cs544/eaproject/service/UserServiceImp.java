package miu.edu.cs544.eaproject.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import miu.edu.cs544.eaproject.service.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImp implements UserService {

    private static final String AUTH_SERVICE_URL = "http://127.0.0.1:8080";

    @Value("${user-service}")
    private String userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @Override
    public UserResponse getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserResponse userResponse = restTemplate.getForObject(lookupUrlFor(userService)+"accounts/get-by-username/"+authentication.getName(), UserResponse.class);
        return userResponse;
    }

    @Override
    public Integer getCurrentUserId() {
        UserResponse userResponse = this.getCurrentUser();
        return userResponse.getId();
    }

    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
}
