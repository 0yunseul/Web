package customer.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;

public class CustomerDelete implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
		//선택한 고객정보를 db에서 삭제한다. 
		//1/선택한 고객정보 삭제 메소드 호출
		int id = Integer.parseInt(request.getParameter("id"));
		CustomerDAO dao = new CustomerDAO();		
		//dao의 customer_delete 메소드를 가져온다. 
		dao.customer_delete(id);
		

	}

}
