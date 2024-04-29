package com.tejait.batch8.serviceimpl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tejait.batch8.service.CustomerService;
@Service("reatail")
//@Primary   
public class ReailCusomerServiceImpl implements CustomerService{

	@Override
	public String getCustomerType() {
		
		return "Retails Customer";
	}

}
