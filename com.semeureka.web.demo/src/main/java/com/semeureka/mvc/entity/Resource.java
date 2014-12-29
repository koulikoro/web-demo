package com.semeureka.mvc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

@Entity
@Table(name = "t_resource")
public class Resource {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "resource_name", nullable = false)
	private String name;
	@Column(name = "resource_path")
	private String path;
	@Column(name = "resource_permission")
	private String permission;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Resource parent;
	@OrderBy("id")
	@OneToMany(mappedBy = "parent")
	private Set<Resource> children;

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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = StringUtils.stripToNull(path);
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = StringUtils.stripToNull(permission);
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public Set<Resource> getChildren() {
		return children;
	}

	public void setChildren(Set<Resource> children) {
		this.children = children;
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
		if (obj instanceof Resource) {
			Resource other = (Resource) obj;
			return id != null ? id.equals(other.id) : other.id == null;
		}
		return false;
	}

	public String getDefaultPath() {
		if (path == null && children != null) {
			for (Resource child : children) {
				if (child.getDefaultPath() != null && !child.isHidden()) {
					return child.getDefaultPath();
				}
			}
		}
		return path;
	}

	public boolean isHidden() {
		Subject subject = SecurityUtils.getSubject();
		return permission == null ? subject.getPrincipal() == null : !subject.isPermitted(permission);
	}

	public boolean isView() {
		return path != null && permission != null;
	}
}
