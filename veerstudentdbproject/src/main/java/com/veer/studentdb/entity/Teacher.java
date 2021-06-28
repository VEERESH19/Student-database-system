package com.veer.studentdb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="t_id")
	private int tId;
	
	@Column(name="t_name")
	private String tName;
	
	
	@Column(name="t_age")
	private int tAge;

}
