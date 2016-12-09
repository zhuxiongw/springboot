package com.vivebest.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class Admin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9010660407925273281L;

	@Id
	private Long id;
	
	private String name;
	
	private String desc;
	
	

	public Admin(Long id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
