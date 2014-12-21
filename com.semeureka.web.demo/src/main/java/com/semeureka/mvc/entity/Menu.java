package com.semeureka.mvc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.semeureka.mvc.misc.ShiroUtils;

@Entity
@Table(name = "t_menu")
public class Menu implements Serializable {
	private static final long serialVersionUID = -4267089411802436437L;
	public static final String PATH_DELIMETER = "/";
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "menu_name")
	private String name;
	@Column(name = "menu_url")
	private String url;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Menu parent;
	@Column(name = "menu_path")
	private String path;
	@OrderBy("path")
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER)
	private Set<Menu> children;
	@Column(name = "menu_permission")
	private String permission;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set<Menu> getChildren() {
		return children;
	}

	public void setChildren(Set<Menu> children) {
		this.children = children;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public boolean isAccessible() {
		if (permission != null) {
			return ShiroUtils.isAccessible(permission);
		} else if (children != null && children.size() > 0) {
			// Any child is accessible return TRUE
			for (Menu child : children) {
				if (child.isAccessible()) {
					return true;
				}
			}
			return false;
		}
		return true;
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
		if (obj instanceof Menu) {
			Menu other = (Menu) obj;
			return id != null ? id.equals(other.id) : other.id == null;
		}
		return false;
	}

}
