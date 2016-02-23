package homework;

public class Person {
	private String username;
	private String password;
	private int id;
	private String name;
	private String age;
	private String hobby;
	private String detail;
	private boolean online;
	public Person(Person p){
		this.username=p.username;
		this.password=p.password;
		this.id=p.id;
		this.name=p.name;
		this.age=p.age;
		this.hobby=p.hobby;
		this.detail=p.detail;
	}
	public Person(String a,String b,int c,String d,String e,String f,String g){
		this.username=a;
		this.password=b;
		this.id=c;
		this.name=d;
		this.age=e;
		this.hobby=f;
		this.detail=g;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getName(){
		return name;
	}
	public String getAge(){
		return age;
	}
	public String getHobby(){
		return hobby;
	}
	public String getDetail(){
		return detail;
	}
	public void  setOnline(boolean b){
		online=b;
	}
	public String checkOnline(){
		if(online==true) return "‘⁄œﬂ";
		return "¿Îœﬂ";
	}
	
	public void update(String b,String c,String d,String e,String f){
		this.password=b;
		this.name=c;
		this.age=d;
		this.hobby=e;
		this.detail=f;
	}
}
