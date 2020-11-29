package az.kapitalbank.gateway.service;

import az.kapitalbank.gateway.model.User;

public interface UserService {
    User retrieveUserByUsername(String username);
}