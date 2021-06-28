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
@Table(name= "student")
public class Student {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="s_id")
	private int sId;
	
	@Column(name="s_name")
	private String sName;
	
	@Column(name="s_department")
	private String sDepartment;
	
	@Column(name="s_age")
	private int sAge;

	
}