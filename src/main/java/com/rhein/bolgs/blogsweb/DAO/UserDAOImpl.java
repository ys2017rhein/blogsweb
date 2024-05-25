package com.rhein.bolgs.blogsweb.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.rhein.bolgs.blogsweb.domain.User;
/**
 * 用户DAO
 * V1.0.0:放进userMap中，不进数据库
 */
@Repository
public class UserDAOImpl implements UserDAO {

	private static AtomicLong counter = new AtomicLong();
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
	
	@Override
	public User SaveOrUpdateUser(User user) {
		Long id = user.getId();
		if (id == null) {
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public int deleteUser(Long id) {
		if (this.userMap.remove(id) != null) {
			return 1;
		}
		return 0;
	}

	@Override
	public User getUserById(Long id) {
		return userMap.get(id);
	}

	@Override
	public List<User> listUsers() {
//		new ArrayList<>().addAll(userMap.values());
		return new ArrayList<>(userMap.values());
	}

}
