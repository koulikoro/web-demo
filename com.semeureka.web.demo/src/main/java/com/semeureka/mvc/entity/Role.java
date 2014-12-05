package com.semeureka.mvc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "role_name")
	private String name;
	@Column(name = "role_description")
	private String description;
	@ManyToMany
	@JoinTable(name = "t_role_permission", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private Set<Permission> permissions;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean contains(String permissionName) {
		if (permissions != null && !permissions.isEmpty()) {
			for (Permission permission : permissions) {
				if (permission.getName().equals(permissionName)) {
					return true;
				}
			}
		}
		return false;
	}
}
