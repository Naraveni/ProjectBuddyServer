package com.example.model;

public class ResetPasswordRequest {
	 private String email;
     private String newPassword;
     private String confirmPassword;
	@Override
	public String toString() {
		return "ResetPasswordRequest [email=" + email + ", newPassword=" + newPassword + ", confirmPassword="
				+ confirmPassword + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
