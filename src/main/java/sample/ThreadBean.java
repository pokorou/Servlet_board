package sample;

public class ThreadBean {
 private int id;
 private String title;
 private String name;
 private String message;
 public int getId() {
	return id;
}

public String getTitle() {
	return title;
}

public String getName() {
	return name;
}

public String getMessage() {
	return message;
}


 
 ThreadBean(int id,String title,String name,String message){
	 this.id=id;
	 this.title=title;
	 this.name=name;
	 this.message=message;
 }
}
