package com.beerdrum.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the all_users database table.
 * 
 */
@Entity
@Table(name="all_users")
@NamedQuery(name="AllUser.findAll", query="SELECT a FROM AllUser a")
public class AllUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="bd_id")
	private String bdId;

	@Column(name="mail_id")
	private String mailId;

	private String name;



	@Column(name="phone_num")
	private String phoneNum;

	private String provider;


	@Column(name="user_type")
	private String userType;

	public AllUser() {
	}

	public String getBdId() {
		return this.bdId;
	}

	public void setBdId(String bdId) {
		this.bdId = bdId;
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProvider() {
		return this.provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}