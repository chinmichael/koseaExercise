package action;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dto.BBSVO;
import dto.CartItemVO;
import dto.ItemVO;
import dto.MemberVO;

public class Crud {
	
	private final String namespace = "mapper.userMapper";
	
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
	
	public MemberVO selectMember(String userid) {
		SqlSession session = getSession();
		MemberVO member = null;
		
		try {
			String stmt = namespace+".selectMember";
			member = session.selectOne(stmt, userid);
			
		} finally {
			session.close();
		}
		
		return member;
	}
	
	public Integer getMaxSeqno() {
		SqlSession session = getSession();
		Integer max = null;
		try {
			String stmt = namespace+".maxSeq";
			max = session.selectOne(stmt);
			if(max == null) max = 0;
			
		} finally {
			session.close();
		}
		return max;
	}
	
	public Integer putBBS(BBSVO bbs) {
		SqlSession session = getSession();
		Integer result  = null;
		try {
			String stmt = namespace+".putBBS";
			result = session.insert(stmt, bbs);
			if(result > 0) session.commit();
			else session.rollback();
		} finally {
			session.close();
		}
		return result;
	}
	
	public Integer getBBSCount() {
		SqlSession session = getSession();
		Integer count = null;
		try {
			String stmt = namespace+".getBBSCount";
			count = session.selectOne(stmt);
			if(count == null) count = 0;
		} finally {
			session.close();
		}
		return count;
	}
	
	public List<BBSVO> getBBS(Integer pageno) {
		SqlSession session = getSession();
		List<BBSVO> bbs = null;
		try {
			String stmt = namespace+".getBBS";
			bbs = session.selectList(stmt, pageno);
			
		} finally {
			session.close();
		}
		return bbs;
	}
	
	public BBSVO getBBSRead(Integer seqno) {
		SqlSession session = getSession();
		BBSVO vo = null;
		
		try {
			String stmt = namespace+".getBBSRead";
			vo = session.selectOne(stmt, seqno);
		} finally {
			session.close();
		}
		
		return vo;
	}
	
	public Integer joinAccount(MemberVO vo) {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace+".joinAccount";
			result = session.insert(stmt, vo);
			if(result > 0) session.commit();
			else session.rollback();
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Integer checkItemID(String code) {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace + ".getItemID";
			result = session.selectOne(stmt, code);
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public Integer putItem(ItemVO item) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace + ".putItem";
			result = session.insert(stmt, item);
			if(result > 0) {
				session.commit();
			} else {
				session.rollback();
			}
			
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public List<ItemVO> getItem(Integer pageno) {
		SqlSession session = getSession();
		List<ItemVO> list = null;
		
		try {
			String stmt = namespace + ".getItem";
			list = session.selectList(stmt, pageno);
			
		} finally {
			session.close();
		}
		
		return list;
	}
	
	public Integer getItemCount() {
		SqlSession session = getSession();
		Integer result = null;
		
		try {
			String stmt = namespace+".getItemCount";
			result = session.selectOne(stmt);
			if(result == null) {
				result = 0;
			}
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public CartItemVO getItemNamePrice(String code) {
		SqlSession session = getSession();
		CartItemVO item = null;
		try {
			String stmt = namespace + ".getItemNamePrice";
			item = session.selectOne(stmt, code);
		} finally {
			session.close();
		}
		return item;
	}
	
	public Integer getMaxSeqnoCart() {
		SqlSession session = getSession();
		Integer max = null;
		try {
			String stmt = namespace+".getMaxSeqnoCart";
			max = session.selectOne(stmt);
			if(max==null) max=0;
		} finally {
			session.close();
		}
		
		return max;
	}
	
	public Integer putCart(CartItemVO item) {
		SqlSession session = getSession();
		Integer result = null;
		try {
			String stmt = namespace+".putCart";
			result = session.insert(stmt, item);
			if(result>0) session.commit(); else session.rollback();
			
		}finally {
			session.close();
		}
		
		return result;
	}
	
	public List<CartItemVO> getCart(String userid) {
		SqlSession session = getSession();
		List<CartItemVO> items = null;
		
		try {
			String stmt = namespace+".getCart";
			items = session.selectList(stmt, userid);
		}finally {
			session.close();
		}
		
		return items;
	}
}
