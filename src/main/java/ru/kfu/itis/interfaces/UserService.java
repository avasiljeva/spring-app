package ru.kfu.itis.interfaces;

import java.util.List;

import ru.kfu.itis.domain.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public void addUser(User user);
}
