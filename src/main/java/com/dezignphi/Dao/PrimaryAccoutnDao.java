package com.dezignphi.Dao;

import com.dezignphi.domain.PrimaryAccount;

public interface PrimaryAccoutnDao extends CrudRepository<PrimaryAccount, Long>
{
	PrimaryAccount findByAccoutNumber(int accountNumber);
}
