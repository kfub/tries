package org.ssm.dufy.service;

import java.util.List;

import org.ssm.dufy.pojo.QueryVo;
import org.ssm.dufy.pojo.User;

public interface UserService {
	
	
	public List<User>findAll();
	public abstract void deleteUser(int id);
	public User updateone(int id);
	public void updateing(User u);
	public void add(User u);
	public void batchdelete(Integer[] vals);
	public List<User> findlike(QueryVo vo);
}
