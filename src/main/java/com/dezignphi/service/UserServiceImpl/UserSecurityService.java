package com.dezignphi.service.UserServiceImpl;

import org.sl4j.Logger;
import org.sl4j.LoggerFactory;
import org.springframework.beans.factory.annaotation.Autowired;
import org.springframework.security.core.userDetails.UserDetails;
import org.springframework.security.core.userDetails.UserDetailsService;
import org.springframework.security.core.userDEtails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dezignphi.Dao.UserDao;
import com.dezignphi.domain.User;

@Service
public class UserSecurityService implements UserDetailsService
{
	private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userDao.findByUsername(username);
		if (null == user)
		{
			LOG.warn("Username {} not found", username);
			throw new UsernameNotFoundException("Username " + username + "not found");
		}

		return user;
	}
}
