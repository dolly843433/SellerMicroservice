package com.seller.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


	@Component
	@Entity
	@Table(name="seller_login")
	public class Model {
		
		@Id
		@Column(name="email_id")
		private String email_id;
		@Column(name="full_name")
		private  String full_name;
		@Column(name="phone_number")
		private String phone_number;
		@Column(name="adress")
		private String adress;
		@Column(name="pin")
		private String pin;
		@Column(name="pan")
		private String pan;
		@Column(name="gst")
		private String gst;
		@Column(name="password")
		private String password;
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		public String getFull_name() {
			return full_name;
		}
		public void setFull_name(String full_name) {
			this.full_name = full_name;
		}
		public String getPhone_number() {
			return phone_number;
		}
		public void setPhone_number(String phone_number) {
			this.phone_number = phone_number;
		}
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public String getPan() {
			return pan;
		}
		public void setPan(String pan) {
			this.pan = pan;
		}
		public String getGst() {
			return gst;
		}
		public void setGst(String gst) {
			this.gst = gst;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Model(String email_id, String full_name, String phone_number, String adress, String pin, String pan,
				String gst, String password) {
			super();
			this.email_id = email_id;
			this.full_name = full_name;
			this.phone_number = phone_number;
			this.adress = adress;
			this.pin = pin;
			this.pan = pan;
			this.gst = gst;
			this.password = password;
		}
		public Model() {
			super();
		}
	
		
      

		
		
		
		
		
		

	}


