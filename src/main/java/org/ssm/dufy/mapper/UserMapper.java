package org.ssm.dufy.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.ssm.dufy.pojo.QueryVo;
import org.ssm.dufy.pojo.User;
import org.ssm.dufy.pojo.Users;


public interface UserMapper {
	public User findone();
	public List<User> selectList();
	public abstract void deleteUser(int id);
	public User updateone(int id);
	public void updateing(User u);
	public void add(User u);
	public void batchdelete(Integer[] vals);
	public List<User> findlike(QueryVo vo);
	//shiroҪ�õĲ�ѯ
	public User shirouser(String str);
	
}
