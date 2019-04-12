package com.dezignphi.Dao;

import org.springframework.data.repository.CrudRepository;

import com.dezignphi.domain.security.Role;

public interface RoleDao extends CrudRepository<Role, Integer>
{
	Role findByName(String name);
}
