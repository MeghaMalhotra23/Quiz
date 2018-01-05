package com.mm.user.operations;

public class UserLogin {
private String username;
private String password;
public UserLogin(String username,String password) {
	this.username=username;
	this.password=password;
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

@Override
public boolean equals(Object o) {
	if(o instanceof UserLogin) {
		UserLogin user=(UserLogin) o;
		return user.password.equals(this.password)&&user.username.equals(this.username); 
	}
	return false;
}
}
