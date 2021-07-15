package kr.co.ch05.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ch05.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(UserVo vo) {
		mybatis.insert("mapper.user.INSERT_USER", vo);
	}
	
	public void selecttUser() {}
	
	public List<UserVo> selectUsers() {
		return mybatis.selectList("mapper.user.SELECT_USERS");
	}
	
	public void updateUser() {}
	
	public void deleteUser(String uid) {
		mybatis.delete("mapper.user.DELETE_USER", uid);
	}
	
}