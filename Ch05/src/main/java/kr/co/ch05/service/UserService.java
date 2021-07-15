package kr.co.ch05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ch05.dao.UserDao;
import kr.co.ch05.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public void insertUser(UserVo vo) {
		dao.insertUser(vo);
	}
	
	public void selecttUser() {}
	
	public List<UserVo> selectUsers() {
		return dao.selectUsers();
	}
	
	public void updateUser() {}
	
	public void deleteUser(String uid) {
		dao.deleteUser(uid);
	}
	
}
