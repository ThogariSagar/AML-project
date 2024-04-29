 package com.tejait.batch8.FactoryDesign;

import java.io.IOException;
import java.util.List;

import com.tejait.batch8.model.Employee;

public interface FileGen {
	public abstract  byte[] genFile(List<Employee> empList)throws IOException;
}
