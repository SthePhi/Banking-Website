package com.dezignphi.service;

import com.dezignphi.domain.User;

import java.util.Set;

import com.dezignphi.domain.User;
import com.dezignphi.domain.security.UserRole;

public interface UserService
{
	User findByUsername(String username);
	User findByEmail(String email);

	boolean checkUserExists(String username, String email);

	boolean checkUsernameExists(String username);

	boolean checkEmailExists();

	void save(User user);

	User createUser(User user, Set<UserRole> userRoles);
}
