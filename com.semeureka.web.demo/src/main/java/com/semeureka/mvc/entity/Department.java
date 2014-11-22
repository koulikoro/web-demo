package com.semeureka.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_department")
public class Department {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "department_name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Department parent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
