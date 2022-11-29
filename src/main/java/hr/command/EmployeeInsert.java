package hr.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import hr.EmployeeDTO;
import hr.HrDAO;

public class EmployeeInsert implements Command {



	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		// 화면에서 입력한 정보를 DB에 저장 
		//1.화면에서 입력한 정보를 수집 ->신규 저장 메소드 호출
		EmployeeDTO dto= new EmployeeDTO();
		dto.setDepartment_id(Integer.parseInt(request.getParameter("department_id")));
		dto.setManager_id(Integer.parseInt(request.getParameter("manager_id")));
		dto.setSalary(Integer.parseInt(request.getParameter("salary")));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone_number(request.getParameter("phone_number"));		
		dto.setHire_date(Date.valueOf(request.getParameter("hire_date")));
		dto.setJob_id(request.getParameter("job_id"));
		
		//신규저장할 메소드 호출
		HrDAO dao = new HrDAO();
		dao.employee_regist(dto);
		
	
	}

}
