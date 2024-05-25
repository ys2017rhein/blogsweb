package com.rhein.bolgs.blogsweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rhein.bolgs.blogsweb.DAO.UserDAO;
import com.rhein.bolgs.blogsweb.DAO.UserDAOImpl;
import com.rhein.bolgs.blogsweb.domain.User;

/**
 * 用户控制器
 * @author daier
 *
 */
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserDAO userDAOImpl = new UserDAOImpl();
	@PostMapping()
	public ModelAndView create(User user, Model model) {
		model.addAttribute("user", userDAOImpl.SaveOrUpdateUser(user));
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form", "userModel", model);
	}
	@RequestMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id, Model model) {
		userDAOImpl.deleteUser(id);
		return new ModelAndView("redirect:/users/list");
	}
	@RequestMapping("/list")
	public ModelAndView list(Model model) {
		model.addAttribute("userList", userDAOImpl.listUsers());
		model.addAttribute("title", "用户管理");
		return new ModelAndView("users/list", "userModel", model);
	}
	@RequestMapping("/{id}")
	public ModelAndView get(@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userDAOImpl.getUserById(id));
		model.addAttribute("title", "查看用户");
		return new ModelAndView("users/view", "userModel", model);
	}
	@RequestMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id") Long id, Model model) {
		User user = userDAOImpl.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("title", "修改用户");
		return new ModelAndView("users/form", "userModel", model);
	}
	
	/**
	 * 获取表单视图
	 * @param model
	 * @return
	 */
	@RequestMapping("/form")
	public ModelAndView form(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		return new ModelAndView("users/form", "userModel", model);
	}

}
