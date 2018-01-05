package com.mm.user.operations;

import java.util.ArrayList;

public class UserLoginOperations {
private ArrayList<UserLogin> list=new ArrayList<>();
private static UserLoginOperations userOperations;
private UserLoginOperations() {}
public static UserLoginOperations getInstance() {
	if(userOperations==null) {
		userOperations=new UserLoginOperations();
	}
		return userOperations;
}

public void viewList() {
list.forEach((t)->System.out.print(t));
}

public String addUser(UserLogin user) {
	list.add(user);
	return "Added";
}
public String searchUser(UserLogin user) {
	return list.contains(user)?"Found":"Not Found";
}
}

