package fadili.mostafa.lambdas.ch02;

import fadili.mostafa.lambdas.employee.Employee;
import fadili.mostafa.lambdas.employee.Unit;

public class EDCFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getUnit()== Unit.EDC;
	}

}
