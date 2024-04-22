package com.example.To.Do.App.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todo_list")

public class todo_list {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)	
private int id;
@Column
private String title;
@Column
private Date date;
@Column
private String status;

public todo_list() {
	super();
}
public todo_list(int id, String litle, Date date, String status) {
	super();
	this.id = id;
	this.title = litle;
	this.date = date;
	this.status = status;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getLitle() {
	return title;
}
public void setLitle(String litle) {
	this.title = litle;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "todo_list [id=" + id + ", litle=" + title + ", date=" + date + ", status=" + status + "]";
}





}
