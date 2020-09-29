package action;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BaseballTeamVO;

public class BaseballCrud {
	
	private final String namespace = "mapper.baseballMapper";
	
	//SqlSession을 사용하여 Mapper를 접근한다
	//따라서, SqlSession을 생성하는 메서드가 필요하다.
	
	private SqlSession getSession() {
		String config = "myBatisConfig.xml"; // MyBatis 환경설정의 파일명
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
	
	public List<String> getBaseHome() {
		SqlSession session = getSession();
		List<String> homeList = null;
		
		try {
			String stmt = namespace+".getHome";
			homeList = session.selectList(stmt);
		} finally {
			session.close();
		}
		
		return homeList;
	}
	
	public Integer getId() {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace+".getId";
			result = session.selectOne(stmt);
			if(result == null) result = 0;
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Integer putTeam (BaseballTeamVO team) {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace + ".putTeam";
			result = session.insert(stmt, team);
			if(result>0) session.commit();
			else session.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	public Integer teamCount () {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace+".teamCount";
			result = session.selectOne(stmt);
			if(result == null) {
				result = 0;
			}
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public List<BaseballTeamVO> getTeamList(Integer pageno) {
		SqlSession session = getSession();
		List<BaseballTeamVO> list = null;
		
		try {
			String stmt = namespace+".getTeamList";
			list = session.selectList(stmt, pageno);
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public List<BaseballTeamVO> getTeam() {
		SqlSession session = getSession();
		List<BaseballTeamVO> list = null;
		
		try {
			String stmt = namespace+".getTeam";
			list = session.selectList(stmt);
			
		} finally {
			session.close();
		}
		
		return list;
	}
}
