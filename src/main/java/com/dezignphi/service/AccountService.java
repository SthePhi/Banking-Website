package com.dezignphi.service;

import com.dezignphi.domain.PrimaryAccount;
import com.dezignphi.domain.SavingsAccount;

public interface AccountService
{
	PrimaryAccount createPrimaryAccount();
	SavingsAccount createSavingsAccount();
}
