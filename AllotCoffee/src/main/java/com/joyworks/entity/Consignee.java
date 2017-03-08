package com.joyworks.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 收货人信息类
 * 
 * @author joyworks
 *
 */
public class Consignee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;// 编号
	private String name;// 姓名
	private String region;// 地区
	private String address;// 地址
	private String tel;// 手机号码
	private String email;// 邮箱
	private String postcode;// 邮编
	private Date createTime;// 添加收货人信息时间
	private Date modifyTime;// 修改收货人时间

	public Consignee() {
		super();
	}

	public Consignee(String name, String region, String address, String tel, String email,
			String postcode) {
		super();
		this.name = name;
		this.region = region;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Consignee [id=" + id + ", name=" + name + ", region=" + region + ", address=" + address + ", tel=" + tel
				+ ", email=" + email + ", postcode=" + postcode + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + "]";
	}

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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
