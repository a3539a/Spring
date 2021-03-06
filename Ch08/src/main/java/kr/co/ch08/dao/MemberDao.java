package kr.co.ch08.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ch08.vo.MemberVO;

@Repository
public interface MemberDao {

	public void insertMember(MemberVO vo);
	
	public MemberVO selectMember(String uid);
	
	public List<MemberVO> selectMembers();
	
	public void updateMember(MemberVO vo);
	
	public void deleteMember();
	
}
