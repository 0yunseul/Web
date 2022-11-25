package customer;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.HanulFactory;

public class CustomerDAO {
	private SqlSession sql; //쿼리문 실행 메소드가 있는 객체
	private void connect() {
		SqlSessionFactory factory= HanulFactory.getInstance();
		sql = factory.openSession(true);
	}
	//전체 고객 목록 조회 메소드 
	public List<CustomerDTO>  customer_list() {  //List<CustomerDTO>로 리턴타입 지정
		connect();
		List<CustomerDTO> list = sql.selectList("customer.list"); //찾아갈 mapper의 namespace. 찾아갈쿼리문태그id
		return list; //화면에 출력하도록 리턴. 
	}
	//선택한 고객 정보를 삭제하는 메소드 
	public void customer_delete(int id) {
		connect();
		sql.delete("customer.delete",id);
	}
	
	//선택한 고객 정보 조회 메소드 
	public CustomerDTO customer_info(int id) {
		connect(); //db연결
		CustomerDTO dto = sql.selectOne("customer.info",id); //id : 파라미터로 선언 
		return dto;
	}
	
	
	//변경한 고객정보 저장 메소드 
	public void customer_update(CustomerDTO dto) {
		connect();
		sql.update("customer.update");
	}
	//신규고객정보저장메소드
	public void customer_insert(CustomerDTO dto) {
		connect();
		sql.insert("customer.insert",dto);
	}

}
