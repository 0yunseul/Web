package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.command.EmployeeCode;
import hr.command.EmployeeInfo;
import hr.command.EmployeeList;
import hr.command.EmployeeUpdate;

@WebServlet("*.hr")
public class HrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getServletPath();
		String view = "";
		boolean redirect = false;
		
		Command cmd = null;
		if( uri.equals("/list.hr") ) {
			//전체 사원목록 화면 요청
			request.getSession().setAttribute("category", "hr");
			//비지니스로직
			cmd = new EmployeeList();
			cmd.exec(request, response);
			
			//응답화면연결
			view = "employee/list.jsp";
			
		}else if( uri.equals("/info.hr") ) {
			//사원정보화면 요청
			cmd = new EmployeeInfo();
			cmd.exec(request, response);
			
			view = "employee/info.jsp";
		}else if (uri.equals("/modify.hr")) {
			//사원정보 수정화면 요청
			cmd = new EmployeeInfo();
			cmd.exec(request, response);
			
			//코드 정보 조회 요청
			cmd = new EmployeeCode();
			cmd.exec(request, response);
			
			//응답화면연결
			view = "employee/modify.jsp";
		}else if(uri.equals("/update.hr")) {
			//사원정보를 변경한 뒤 저장하는 처리를 요청
			cmd= new EmployeeUpdate();
			cmd.exec(request, response); 
			
			view = "info.hr?id=" + request.getParameter("employee_id");
			redirect = true;
			
		}
		
		if( redirect ) response.sendRedirect(view);
		else 
			request.getRequestDispatcher(view)
						.forward(request, response);
			
		
	}
	

}
