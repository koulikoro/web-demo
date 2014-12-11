package com.semeureka.mvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_organization")
public class Organization implements Serializable {
	private static final long serialVersionUID = -2670131404732587276L;
	public static final String PATH_DELIMETER = "/";
	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "organization_name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "parent_id", updatable = false)
	private Organization parent;
	@Column(name = "organization_path", updatable = false)
	private String path = PATH_DELIMETER;

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

	public Organization getParent() {
		return parent;
	}

	public void setParent(Organization parent) {
		this.parent = parent;
		if (parent != null) {
			path = parent.path + parent.id + PATH_DELIMETER;
		}
	}

	public String getPath() {
		return path;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Organization other = (Organization) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
