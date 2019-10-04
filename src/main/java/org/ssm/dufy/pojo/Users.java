package org.ssm.dufy.pojo;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Users {
		private int id;
		private String username;
		private String password;
		private String password_salt;
		private String status;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPassword_salt() {
			return password_salt;
		}
		public void setPassword_salt(String password_salt) {
			this.password_salt = password_salt;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Users [id=" + id + ", username=" + username + ", password=" + password + ", password_salt="
					+ password_salt + ", status=" + status + "]";
		}
		
}
