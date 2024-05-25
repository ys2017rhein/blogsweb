package com.rhein.bolgs.blogsweb.DAO;

import java.util.List;

import com.rhein.bolgs.blogsweb.domain.User;

/**
 * 用户 DAO接口
 * @author daier
 *
 */
public interface UserDAO {

	/**
	 * 创建过修改用户
	 * @param user
	 * @return
	 */
	User SaveOrUpdateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int deleteUser(Long id);
	
	/**
	 * 根据id获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 分页获取用户
	 * @return
	 */
	List<User> listUsers();
}
