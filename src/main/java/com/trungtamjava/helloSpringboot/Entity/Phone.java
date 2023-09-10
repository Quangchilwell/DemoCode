package com.trungtamjava.helloSpringboot.Entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "phone")
public class Phone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "phone_number")
	private String phone;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
}