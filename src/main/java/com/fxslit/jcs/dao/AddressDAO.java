package com.fxslit.jcs.dao;

import com.fxslit.jcs.entity.Address;

public interface AddressDAO{
	Address getByTel(Address address);
	int insert(Address obj);
	int checkSender(Address address);
	int checkReceiver(Address address);
}
