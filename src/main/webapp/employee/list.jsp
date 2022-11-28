<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />        
<title>Insert title here</title>
</head>
<body>
<div class="d-flex" id="wrapper">
<!-- Sidebar-->
<jsp:include page="/include/sidebar.jsp"/> 
<!-- Page content wrapper-->
<div id="page-content-wrapper">
	<!-- Top navigation-->
	<jsp:include page="/include/navigation.jsp"/> 

	<!-- Page content-->
	<div class="container-fluid">
		<h2 class="mt-4">사원목록</h2>
		<div id='list-top' class='w-px900'>
		<ul>
			<li>부서명</li>
			<li>
				<select class='w-px200'>
					
				<c:forEach items='${departments}' var="name">
					<option> ${name.department_name}			
					</option>
					</c:forEach>
				
<!-- 					<option>총무부</option> -->
				</select>
			</li>
		</ul>
		</div>
		<table class='w-px900 tb-list'>
		<colgroup>
			<col width='80px'>
			<col width='230px'>
			<col width='200px'>
			<col>
			<col width='120px'>
		</colgroup>
		<tr>
			<th>사번</th>
			<th>사원명</th>
			<th>부서</th>
			<th>업무</th>
			<th>입사일자</th>
		</tr>
		<c:forEach items='${list}' var='dto'>
		<tr>
			<td>${dto.employee_id }</td>
			<td><a href='info.hr?id=${dto.employee_id}'>${dto.name}</a></td>
<%-- 			<td>${dto.last_name} ${dto.first_name}</td> --%>
			<td>${dto.department_name }</td>
			<td>${dto.job_title }</td>
			<td>${dto.hire_date }</td>
		</tr>
		</c:forEach>
		</table>

	</div>
</div>
</div>
</body>
</html>
