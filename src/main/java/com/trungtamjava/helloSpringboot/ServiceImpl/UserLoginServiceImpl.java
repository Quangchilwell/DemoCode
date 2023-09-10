//package com.trungtamjava.helloSpringboot.ServiceImpl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.trungtamjava.helloSpringboot.Dao.EmployeeDao;
//import com.trungtamjava.helloSpringboot.Entity.Employee;
//
//@Service
//@Transactional
//public class UserLoginServiceImpl implements UserDetailsService{
//
//	@Autowired
//	EmployeeDao employeeDao;
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Employee emp = employeeDao.getEmployeeByUsername(username);
//		
//		if(emp == null) {
//			throw new UsernameNotFoundException("no user");
//		}
//		
//		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(emp.getRole()));
//	
//		UserDetails details = new User(emp.getUsername(), "{noop}" + emp.getPassword(), true, true, true, true, authorities);
//		return details;
//	}
//
//}
