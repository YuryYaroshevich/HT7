package com.epam.ht.db.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.epam.ht.entity.employee.Employee;
import com.epam.ht.util.SessionFactoryGetter;

final class EmployeeDAOHibernate implements EmployeeDAO {
	private static EmployeeDAOHibernate dao = new EmployeeDAOHibernate();

	private static SessionFactory sessionFactory;
	static {
		sessionFactory = SessionFactoryGetter.getSessionFactory();
	}

	// query name
	private static final String CORRESPOND_EMPLOYEE_IDS = "query.CorrespondEmployeeIds";
	private static final String EMPLOYEE_LIST = "query.EmployeeList";
	private static final String CORRESPOND_OFFICES = "query.CorrespondOffices";
	private static final String CORRESPOND_OFFICE_IDS = "query.CorrespondOfficeIds";

	// parameter names for queries
	private static final String EMPLOYEE_IDS_PARAM = "employee_ids";
	private static final String OFFICE_IDS_PARAM = "office_ids";
	private static final String ROWS_NUMBER = "rows_number";

	private EmployeeDAOHibernate() {
	}

	public static EmployeeDAO getInstance() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees(int rowsNumber) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// get ids of first 100 employees
		List<Long> employeeIds = session.getNamedQuery(CORRESPOND_EMPLOYEE_IDS)
				.setParameter(ROWS_NUMBER, rowsNumber).list();
		// get id of offices where first 100 employees work
		List<Long> officeIds = session.getNamedQuery(CORRESPOND_OFFICE_IDS)
				.setParameterList(EMPLOYEE_IDS_PARAM, employeeIds).list();
		// load in session correspond offices
		session.getNamedQuery(CORRESPOND_OFFICES)
				.setParameterList(OFFICE_IDS_PARAM, officeIds).list();
		// get employees
		List<Employee> employees = session.getNamedQuery(EMPLOYEE_LIST)
				.setParameterList(EMPLOYEE_IDS_PARAM, employeeIds).list();

		tx.commit();
		return employees;
	}
}
