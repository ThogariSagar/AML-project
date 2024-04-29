package com.tejait.batch8.dtodesignpattren;

import lombok.Data;

@Data
public class PersonCardRequestDto {
	String pname;
	int age;
	long cardnum;
	String holder;
	int cvv;
	int pin;

}
