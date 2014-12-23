package com.semeureka.mvc.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "t_resource")
public class Resource implements Serializable {
	private static final long serialVersionUID = 8191640268421344861L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "resource_name")
	private String name;
	@Column(name = "resource_path")
	private String path;
	@Column(name = "resource_permission")
	private String permission;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Resource parent;
	@OneToMany(mappedBy = "parent")
	@OrderBy("id")
	private Set<Resource> children;
	@Column(name = "resource_hidden")
	private boolean hidden;

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
		this.name = StringUtils.trimToNull(name);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = StringUtils.trimToNull(path);
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = StringUtils.trimToNull(permission);
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

	public boolean isHidden() {
		return hidden ? true : (permission == null ? false : !SecurityUtils.getSubject().isPermitted(permission));
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
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
		if (obj instanceof User) {
			Resource other = (Resource) obj;
			return id != null ? id.equals(other.id) : other.id == null;
		}
		return false;
	}

}
