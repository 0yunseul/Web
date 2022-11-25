<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
          <jsp:include page="/include/sidebar.jsp"></jsp:include>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                			<jsp:include page="/include/navigation.jsp"></jsp:include>
                <!-- Page content-->
                <div class="container-fluid">
                    <h1 class="mt-4">고객정보수정</h1>    
                    <form method='post' action='update.cu'>
                    <input type='hidden' name ='id' value=${dto.id }>
                   <table class='w-px600'>
                   <tr><th class='w-px400'>고객명</th>
                   		<td><input type='text' name='name' value='${dto.name}'></td>
                   	</tr>
                   	   <tr><th>성별</th>
                   		<td><input type='radio' ${dto.gender eq '남' ? 'checked' : ''} name='gender' value='남' >남
                   		<input type='radio'	${dto.gender eq '여' ? 'checked' : ''} name='gender' value='여'>여</td>
                   	</tr>
                   	   <tr><th>이메일</th>
                   		<td><input type='text' value='${dto.email}' name='email' ></td>
                   	</tr>
                   	   <tr><th>전화번호</th>
                   		<td><input type='text' value='${dto.phone}' name='phone' ></td>
                   	</tr>
                   </table>
                   </form> 
                   <div class='btnSet'>
                   	<button class='btn btn-primary' onclick="$('form').submit()">저장</button>
                   </div>               
                </div>
            </div>
        </div>    
    </body>
</html>