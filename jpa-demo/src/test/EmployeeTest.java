package test;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;
import service.EmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("jpa-demo");
		EntityManager em = emf.createEntityManager();
		EmployeeService service = new EmployeeService(em);

		// create and persist an employee
		em.getTransaction().begin();
		Employee emp = service.createEmployee(158, "John Doe", 45000);
		em.getTransaction().commit();
		System.out.println("Persisted " + emp);

		// find a specific employee
		emp = service.findEmployee(158);
		System.out.println("Found " + emp);

		// find all employees
		Collection<Employee> emps = service.findAllEmployees();
		for (Employee e : emps)
			System.out.println("Found Employee: " + e);

		// update the employee
		em.getTransaction().begin();
		emp = service.raiseEmployeeSalary(158, 1000);
		em.getTransaction().commit();
		System.out.println("Updated " + emp);

		// remove an employee
//		em.getTransaction().begin();
//		service.removeEmployee(158);
//		em.getTransaction().commit();
//		System.out.println("Removed Employee 158");

		// close the EM and EMF when done
		em.close();
		emf.close();
	}
}
