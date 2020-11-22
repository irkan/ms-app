package az.kapitalbank.eureka.service;

import az.kapitalbank.eureka.model.User;

public interface UserService {
    User retrieveUserByUsername(String username);
}