<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/employeeList.css"
	media="screen" />
<title>Employee list</title>
</head>
<body>
	<h2>Employee list</h2>
	<table>
		<tr>
			<th rowspan="2">Index</th>
			<th rowspan="2">Name</th>
			<th rowspan="2">Address</th>
			<th colspan="6">Offices</th>
		</tr>
		<tr>
			<th>Company name</th>
			<th>City</th>
			<th>Country</th>
			<th>Address</th>
			<th>Number of employees<br>for given company office
			</th>
			<th>Position</th>

		</tr>
		<jstl:forEach var="employee" items="${employees}" varStatus="counter">
			<tr>
				<jstl:choose>
					<jstl:when test="${fn:length(employee.jobs) == 1}">
						<td>${counter.count}</td>
						<td>${employee.id} ${employee.firstName} ${employee.lastName}</td>
						<td>${employee.address.id} ${employee.address}</td>
					</jstl:when>
					<jstl:otherwise>
						<td rowspan="${fn:length(employee.jobs)}">${counter.count}</td>
						<td rowspan="${fn:length(employee.jobs)}">${employee.id}
							${employee.firstName} ${employee.lastName}</td>
						<td rowspan="${fn:length(employee.jobs)}">${employee.address.id}
							${employee.address}</td>
					</jstl:otherwise>
				</jstl:choose>
				<jstl:forEach var="job" items="${employee.jobs}" varStatus="status">
					<jstl:if test="${status.index != 0}">
			</tr>
			<tr>
				</jstl:if>
				<td>${job.key.company.id} ${job.key.company}</td>
				<td>${job.key.address.city.id} ${job.key.address.city}</td>
				<td>${job.key.address.city.country.id}
					${job.key.address.city.country}</td>
				<td>${job.key.address.id} ${job.key.address}</td>
				<td>${job.key.numberOfEmployees}</td>
				<td>${job.value}</td>
				<jstl:if test="${(status.index != 0) && (!status.last)}">
			</tr>
			</jstl:if>
		</jstl:forEach>
		</tr>
		</jstl:forEach>
	</table>
</body>
</html>