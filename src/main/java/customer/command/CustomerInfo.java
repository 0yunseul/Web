package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerInfo implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
	//선택한 고객정보를 DB에서 조회하고
		int id = Integer.valueOf( request.getParameter("id"));
		CustomerDAO dao = new CustomerDAO(); //선택한 고객정보 조회 메소드 호출 
		CustomerDTO dto = dao.customer_info(id);
		
	//화면에 출력하도록 request에 담는다. 
		request.setAttribute("dto", dto);
	}

}
