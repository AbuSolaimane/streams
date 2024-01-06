package fadili.mostafa.lambdas.ch02;

import fadili.mostafa.lambdas.employee.Employee;
import fadili.mostafa.lambdas.employee.Skill;

public class JavaSkillsFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getSkills().contains(Skill.JAVA);
	}

}
