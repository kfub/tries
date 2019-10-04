package org.ssm.dufy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dufy.mapper.UserMapper;
import org.ssm.dufy.pojo.QueryVo;
import org.ssm.dufy.pojo.User;
import org.ssm.dufy.service.UserService;


@Service
public class UserSeriveImpl implements UserService {
	
	@Autowired
	public UserMapper u;
	
	@Override
	public List<User> findAll() {
		 List<User> list = u.selectList();
		return list;
	}

	@Override
	public void deleteUser(int id) {
		u.deleteUser(id);
		
	}

	@Override
	public User updateone(int id) {
		
		return u.updateone(id);
	}

	@Override
	public void updateing(User id) {
		
		 u.updateing(id);
	}

	@Override
	public void add(User us) {
		u.add(us);
		
	}

	@Override
	public void batchdelete(Integer[] vals) {
		
		u.batchdelete(vals);
	}

	@Override
	public List<User> findlike(QueryVo vo) {
		
		return u.findlike(vo);
	}

}
