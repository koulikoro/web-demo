package com.semeureka.mvc.entity;

import java.io.Serializable;
import java.util.Date;

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
	@JoinColumn(name = "parent_id")
	private Organization parent;
	@Column(name = "organization_path")
	private String path;
	@Column(name = "create_time", updatable = false)
	private Date createTime;
	@Column(name = "update_time")
	private Date updateTime;

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
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
		if (obj instanceof Organization) {
			Organization other = (Organization) obj;
			return id != null ? id.equals(other.id) : other.id == null;
		}
		return false;
	}

}
