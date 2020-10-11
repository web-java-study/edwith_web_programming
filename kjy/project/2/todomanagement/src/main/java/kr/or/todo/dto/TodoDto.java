package kr.or.todo.dto;

import java.util.Date;

public class TodoDto {

	private int id;
	private String title;
	private String name;
	private int seq;
	private Date reg_date;
	private String type;


	
	public TodoDto(int id, String title, String name, int seq, String type, Date reg_date) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.seq = seq;
		this.reg_date = reg_date;
		this.type = type;
	}
	
	public TodoDto(String title, String name, int seq) {
		this.title = title;
		this.name = name;
		this.seq = seq;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getSeq() {
		return seq;
	}
	
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", name=" + name + ", seq=" + seq + ", reg_date=" + reg_date+"type = " + type
				+ "]";
	}
}
