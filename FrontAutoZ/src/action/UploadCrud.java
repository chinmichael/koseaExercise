package action;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.Condition;
import dto.WritingVO;

public class UploadCrud {

	private final String namespace = "mapper.uploadMapper";

	// SqlSession을 사용하여 Mapper를 접근한다
	// 따라서, SqlSession을 생성하는 메서드가 필요하다.

	private SqlSession getSession() {
		String config = "myBatisConfig.xml"; // MyBatis 환경설정의 파일명
		InputStream is = null;// 파일처리(파일로부터 입력)을 위한 객체

		try {
			is = Resources.getResourceAsStream(config); // 환경설정파일을 읽음

		} catch (Exception e) {
			e.printStackTrace();
		}

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(is); // 환경설정파일을 통해 생성
		SqlSession session = factory.openSession();

		return session;
	}
	
	public Integer getMaxId() {
		SqlSession session =  getSession();
		Integer result = null;
		
		try {
			String stmt = namespace + ".getMaxId";
			result = session.selectOne(stmt);
			
			if(result == null) result = 0;
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Integer putImageWriting(WritingVO vo) {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace + ".putImageWriting";
			result = session.insert(stmt, vo);
			
			if(result > 0) session.commit();
			else session.rollback();
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Integer getTotalCnt() {
		SqlSession session = getSession();
		String stmt = namespace + ".getTotalCnt";
		Integer result = null;
		
		try {
			result = session.selectOne(stmt);
			if(result == null) result = 0;
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public List<WritingVO> getImageList(Condition c) {
		SqlSession session = getSession();
		String stmt = namespace + ".getImageList";
		List<WritingVO> list = null;
		
		try {
			list = session.selectList(stmt, c);
			
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public WritingVO getImage(Integer no) {
		SqlSession session = getSession();
		String stmt = namespace + ".getImage";
		WritingVO writing = null;
		try {
			writing = session.selectOne(stmt, no);
			
		} finally {
			session.close();
		}
		return writing;
	}
	
	public Integer deleteImage(Integer id) {
		SqlSession session = getSession();
		String stmt = namespace + ".deleteImage";
		Integer result = null;
		
		try {
			result = session.delete(stmt, id);
			if(result > 0) session.commit();
			else session.rollback();
			
		} finally {
			session.close();
		}
		return result;
	}
	
	public Integer modifyImage(WritingVO vo) {
		SqlSession session = getSession();
		String stmt = namespace + ".modifyImage";
		Integer result = null;
		
		try {
			result = session.update(stmt, vo);
			if(result > 0) session.commit();
			else session.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	public Integer selectRownum(Integer id) {
		SqlSession session = getSession();
		Integer result = null;
		String stmt = namespace + ".selectRownum";
		try {
			result = session.selectOne(stmt, id);
		} finally {
			session.close();
		}
		return result;
	}
	
	public Integer updateOrderNo(WritingVO vo) {
		SqlSession session = getSession();
		Integer result = null;
		String stmt = namespace + ".updateOrderNo";
		try {
			result = session.update(stmt, vo);
			if(result > 0) session.commit();
			else session.rollback();
		} finally {
			session.close();
		}
		return result;
	}

}
