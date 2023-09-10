package com.trungtamjava.helloSpringboot.Entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int age;

	@Lob
	private String name;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@Lob
	private String avatar;
	
	/*  
		cascade = CascadeType.ALL: Thêm mới, cập nhật hoặc xóa tự động các bản ghi của bảng có liên kết nhiều
		với bảng có LK 1. Ví dụ như thêm mới 1 emp thì các số điện thoại sẽ từ động thêm mới theo.
	 * */
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Phone> phones;

}