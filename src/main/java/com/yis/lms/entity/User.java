package com.yis.lms.entity;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String userName;
	private String phone;
	private String email;
	private String organizationId;
	private String qq;
	private String picture;
	private String createTime;
	private String password;
	private int type;

}
