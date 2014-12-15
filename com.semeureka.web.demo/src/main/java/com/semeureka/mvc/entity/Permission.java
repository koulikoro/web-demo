package com.semeureka.mvc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {
	private static final long serialVersionUID = 2518763746330214692L;
	public static final String ROOT_PERMISSION = "*";
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "permission_name")
	private String name;
	@Column(name = "permission_value", unique = true, nullable = false)
	private String value;
	@Column(name = "permission_description")
	private String description;
	@OneToMany
	@JoinColumn(name = "parent_id")
	@OrderBy("id")
	private Set<Permission> children;

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

	public String getValue() {
		return value != null && !value.isEmpty() ? value : "permission" + id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Permission> getChildren() {
		return children;
	}

	public void setChildren(Set<Permission> children) {
		this.children = children;
	}

	@Override
	public int hashCode() {
		return getValue().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permission other = (Permission) obj;
		return getValue().equals(other.getValue());
	}
}
