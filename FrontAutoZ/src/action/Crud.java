package action;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.MemberVO;

public class Crud {
	//SqlSession을 사용하여 Mapper를 접근한다
	//따라서, SqlSession을 생성하는 메서드가 필요하다.
	
	private SqlSession getSession() {
		String config = "mybatisConfig.xml"; // MyBatis 환경설정의 파일명
		InputStream is = null;//파일처리(파일로부터 입력)을 위한 객체
		
		try {
			is = Resources.getResourceAsStream(config); //환경설정파일을 읽음
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is); //환경설정파일을 통해 생성
		SqlSession session = factory.openSession();
		
		return session;
	}
	
	public MemberVO selectMember(String id) {
		SqlSession session = getSession();
		MemberVO member = null;
		
		try {
			String stmt = "mapper.userMapper.selectMember";
			member = session.selectOne(stmt, id);
			
		} finally {
			session.close();
		}
		
		return member;
	}
}
