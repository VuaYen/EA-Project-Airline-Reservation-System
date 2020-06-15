package miu.edu.cs544.eaproject.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {
}
