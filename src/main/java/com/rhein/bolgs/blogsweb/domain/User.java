package com.rhein.bolgs.blogsweb.domain;

// 用户实体类
public class User {

	/**
	 * id
	 */
	private Long id;
	/**
	 * 昵称
	 */
	private String name;
	/**
	 * 邮箱
	 */
	private String email;
	
	
	@Override
	public int hashCode() {
		return this.id.hashCode() + this.name.hashCode() + this.email.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		if (this == obj)
			return true;
		User user = (User) obj;
		return this.id.equals(user.getId()) 
			&& this.name.equals(user.getName()) 
			&& this.email.equals(user.getEmail());
	}
	@Override
	public String toString() {
		return this.id + "," +this.name + "," + this.email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
