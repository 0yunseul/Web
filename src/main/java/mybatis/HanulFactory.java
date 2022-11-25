package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HanulFactory {
	private static SqlSessionFactory factory;
	static {
		String resource = "mybatis/hanul_config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static SqlSessionFactory getInstance() {
		return factory;
	}

}
