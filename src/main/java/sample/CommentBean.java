package sample;

public class CommentBean {
private int id;
private int threadNumber;
private String name;
private String message;

public CommentBean(int threadNumber,String name,String message) {
	this.threadNumber=threadNumber;
	this.name=name;
	this.message=message;
}
}
