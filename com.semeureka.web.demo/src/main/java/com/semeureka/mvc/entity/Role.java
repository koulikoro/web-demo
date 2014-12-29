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

import org.apache.commons.lang3.StringUtils;

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
	@JoinTable(name = "t_role_resource", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "resource_id"))
	private Set<Resource> resources;

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
		this.name = StringUtils.stripToNull(name);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = StringUtils.stripToNull(value);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = StringUtils.stripToNull(description);
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Role) {
			Role other = (Role) obj;
			return id != null ? id.equals(other.id) : other.id == null;
		}
		return false;
	}

}
