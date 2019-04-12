package com.dezignphi.domain.security;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.dezignphi.domain.User;

public class UserRole
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRoleId;

	public UserRole(User user, Role role)
	{
		this.user = user;
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	public UserRole(){}

	public long getUserRoleId()
	{
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId)
	{
		this.userRoleId = userRoleId;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Role getRole()
	{
		return role;
	}

	public void setRole(Role role)
	{
		this.role = role;
	}
}
