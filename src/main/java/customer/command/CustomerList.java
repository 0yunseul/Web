package customer.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerList implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
	//db에서 전체 고객목록을 조회해온다
		CustomerDAO dao = new CustomerDAO();
		List<CustomerDTO> list = dao.customer_list(); //여러명 
		
		
	//화면에 출력할 수 있도록 request에 attribute로 담는다. 	
		request.setAttribute("list", list);
		//session을 찾아가서 값을 담는다. 
		request.getSession().setAttribute("category", "cu");
		
	}

	
}
