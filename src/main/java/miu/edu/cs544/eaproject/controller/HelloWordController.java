package miu.edu.cs544.eaproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("helloword")
public class HelloWordController {
    @RequestMapping("/hello")
    public String HelloWord(){
        return  "Hello";
    }
}
