package kr.co.sboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard.vo.MemberVO;

@Repository
public interface UserDao {

	public void insertUser(MemberVO vo); 
	public MemberVO selectUser(MemberVO vo); 
	public List<MemberVO> selectUsers(); 
	public void updateUser(String uid);
	public void deleteUser(String uid);
}
