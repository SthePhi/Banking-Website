package com.dezignphi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dezignphi.Dao.RoleDao;
import com.dezignphi.domain.security.UserRole;
import com.dezignphi.domain.User;
import com.dezignphi.service.UserService;

@Controller
public class HomeController
{
	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String home()
	{
		return "redirect:/index";
	}

	@RequestMapping("/index")
        public String index()
        {
                return "index";
        }

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model)
	{
		User user = new User();

		model.addAttribute("user", user);

		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(@ModelAttribute("user") User user, Model model)
	{
		if (userService.checkUserExists(user.getUsername(), user.getEmail()))
		{
			if (userService.checkEmailExists(user.getEmail()))
			{
				model.addAttribute("emailExists", true);
			}

			if (userService.checkUsernameExists(user.getUsername()))
			{
				model.addAttribute("usernameExist", true);
			}

			return "signup";
		}
		else
		{
			Set<UserRole> userRoles = new HashSet<>();
			userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			userService.createUser(user, UserRoles);

			return "redirect:/";
		}
	}

	@RequestMapping("/userFront")
	public String userFront()
	{
		User user = userService.findByUsername(principal.getName());
		PrimaryAccount primaryAccount = user.getPrimaryAccount();
		SavingsAccount savingsAccount = user.getSavingsAccount();

		model.addAttribute("primaryAccount", primaryAccount);
		model.addAttribute("savingsAccount", savingsAccount);

		return "userFront";
	}

}
