package com.offcn.po;

import java.util.List;

public class ActiveUser {
private String username;
private List<Permission> permissions;
private List<Role> Roles;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public List<Permission> getPermissions() {
	return permissions;
}
public void setPermissions(List<Permission> permissions) {
	this.permissions = permissions;
}
public List<Role> getRoles() {
	return Roles;
}
public void setRoles(List<Role> roles) {
	Roles = roles;
}


}
