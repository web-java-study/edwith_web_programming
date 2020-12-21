package dto;

import java.util.Date;

public class TodoDto {
	private Long id;
	private String name;
	private Date regDate;
    private int sequence;
    private String title;
    private String type;

    public TodoDto() {
    	
    }
    
    public TodoDto(Long id, String name, Date regDate, int sequence, String title, String type) {
        this.id = id;
        this.name = name;
        this.regDate = regDate;
        this.sequence = sequence;
        this.title = title;
        this.type = type;
    }
    
    public TodoDto(String title, String name, int sequence) {
    	this.title = title;
    	this.name = name;
    	this.sequence = sequence;
    }

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
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

    @Override
    public String toString() {
        return "Todo [id= " +id + ", name= " +name + ", regdate= " +regDate + ", sequence= " +sequence + ", title= " +title + ", type= " + type + "]";
    }


}