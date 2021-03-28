package com.firstspringapp.service;

import com.firstspringapp.model.Greeting;
import com.firstspringapp.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
}
