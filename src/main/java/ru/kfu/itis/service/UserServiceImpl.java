package ru.kfu.itis.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import ru.kfu.itis.domain.User;
import ru.kfu.itis.interfaces.UserService;

@Component
public class UserServiceImpl implements UserService {

	private AtomicLong idGenerator = new AtomicLong(0L);
	
	private static final List<User> users = new ArrayList<User>();
	
	public List<User> getUsers() {
		return Collections.unmodifiableList(users);
	}

	public void addUser(User user) {
		user.setId(idGenerator.getAndIncrement());
		users.add(user);
	}
}
