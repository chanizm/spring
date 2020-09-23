package com.yi.domain;

import java.util.Date;

import lombok.Data;

@Data

public class BoardVO {

	private int  message_id;
	private String guest_name;
	private String password;
	private String message;
	private Date regdate;
	private Date updateDate;
}