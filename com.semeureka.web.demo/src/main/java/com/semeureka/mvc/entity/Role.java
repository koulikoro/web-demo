package com.semeureka.mvc.entity;

import java.io.Serializable;
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
public class Role implements Serializable {
	private static final long serialVersionUID = 8913103763305771359L;
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "role_name", unique = true, nullable = false)
	private String name;
	@Column(name = "role_value")
	private String value;
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

	public String getValue() {
		return value == null || value.isEmpty() ? "role" + id : value;
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

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public boolean hasPermission(String permission) {
		if (permissions != null) {
			for (Permission p : permissions) {
				if (p.getValue().equals(permission)) {
					return true;
				}
			}
		}
		return false;
	}
}
