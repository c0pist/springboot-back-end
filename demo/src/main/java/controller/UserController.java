package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mapper.UserMapper;
import vo.UserVO;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping
	public List<UserVO> userList() {
		System.out.println(userMapper.userList());
		System.out.println("User List successfully loaded.");
		return userMapper.userList();
	}
	
	@PostMapping
	void insertUser(@RequestBody UserVO user) {
		userMapper.insertUser(user);
		System.out.println("User DB saved successfully.");
	}
	
	@GetMapping("/{id}")
	public UserVO fetchUserByID(@PathVariable int id) {
		System.out.println(userMapper.fetchUserByID(id));
		UserVO fetchUser = userMapper.fetchUserByID(id);
		return fetchUser;
	}
	
	@PutMapping("/{id}")
	public void updateUser(@PathVariable int id, @RequestBody UserVO user) {
		
		UserVO updateUser = user;
		System.out.println("Update User => " + updateUser);
		
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setSalary(user.getSalary());
		
		userMapper.updateUser(updateUser);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		userMapper.deleteUser(id);
		System.out.println("User Deleted Successfully.");
	}
	
}