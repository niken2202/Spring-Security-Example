package com.example.dao;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

import com.example.model.User;

@Repository
public class UserRepository {

	public UserRepository() {

	}

	public User getUser(String username) {

		return new User("thang", "123456", Arrays.asList("USER", "CREATE", "DELETE"));
	}

}
