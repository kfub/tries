package org.ssm.dufy.mapper;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Repository;
import org.ssm.dufy.pojo.Users;

@Repository
public interface UsersMapper {
	public Users findone(String users);
	
	public void addUsers(Users users);
	public List<Users> findAll();
}
