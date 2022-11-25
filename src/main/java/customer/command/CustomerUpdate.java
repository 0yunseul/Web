package customer.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Command;
import customer.CustomerDAO;
import customer.CustomerDTO;

public class CustomerUpdate implements Command {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) {
	//db에서 전체 고객목록을 조회해온다
		// 변경된 고객정보를 DB에 저장한다. 
		//1.화면에서 입력한 정보를 수집한다. 
		//데이터를 transfer할 객체 필요
			CustomerDTO dto = new CustomerDTO();
			dto.setId(Integer.parseInt(request.getParameter("id")));
			//여기에 데이터를담는다.
			//데이터를 post방식을 넘겼기때문에 (form method ='post') 
			dto.setName(request.getParameter("name"));
			dto.setGender(request.getParameter("gender"));
			dto.setEmail(request.getParameter("email"));
			dto.setPhone(request.getParameter("phone"));
		//2.수집한 정보로 DB에 변경저장처리 : 변경저장메소드 호출
			CustomerDAO dao = new CustomerDAO();
			dao.customer_update(dto);
			//id는 내부적으로 사용하는데만 쓰이고, 화면상 사용자에게 보여질 필요가 없음->hidden 으로 
		
	}

	
}
