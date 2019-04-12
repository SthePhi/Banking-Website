package com.dezignphi.service.UserServiceImpl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dezignphi.domain.PrimaryAccount;
import com.dezignphi.domain.SavingsAccount;
import com.dezignphi.service.AccountService;
import com.dezignphi.service.UserService;

@Service
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private PrimaryAccountDao primaryAccountDao;

	@Autowired
	private SavingsAccountDao savingsAccoutnDao;

	@Autowired
	private UserService userService;

	public PrimaryAccount createPrimaryAccount()
	{
		PrimaryAccount primaryAccount = new PrimaryAccount();
		primaryAccount.setAccountBalance(new BigDecimal(0.0));
		primaryAccount.setAccountNumber(accountGen);

		primaryAccountDao.save(primaryAccount);

		return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	public SavingsAccount createSavingsAccount()
        {
                SavingsAccount savingsAccount = new SavingsAccount();
                savingsAccount.setAccountBalance(new BigDecimal(0.0));
                savingsAccount.setAccountNumber(accountGen);

                savingsAccountDao.save(primaryAccount);

                return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
        }

	private int accountGen()
	{
		return ++nextAccountNumber;
	}
}
