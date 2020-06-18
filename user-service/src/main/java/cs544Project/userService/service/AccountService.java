package cs544Project.userService.service;

import cs544Project.userService.service.response.UserResponse;

public interface AccountService {
    public UserResponse getAccountById(int id);
    public UserResponse getAccountByUsername(String username);
}
