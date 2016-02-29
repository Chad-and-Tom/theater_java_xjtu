package homework;

public class Person {
	private String username;
	private String password;
	private int id;
	private String name;
	private String age;
	private String hobby;
	private String detail;
	private int row=-1;
	private int column=-1;
	private boolean ticket;
	private boolean online;
	public Person(Person p){
		this.username=p.username;
		this.password=p.password;
		this.id=p.id;
		this.name=p.name;
		this.age=p.age;
		this.hobby=p.hobby;
		this.detail=p.detail;
		this.row=p.row;
		this.column=p.column;
	}
	public Person(String a,String b,int c,String d,String e,String f,String g){
		this.username=a;
		this.password=b;
		this.id=c;
		this.name=d;
		this.age=e;
		this.hobby=f;
		this.detail=g;
		this.row=-1;
		this.column=-1;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public int getId(){
		return id;
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
	public boolean getTicket(){
		return ticket;
	}
	public int getRow(){
		return row;
	}
	public int getColumn(){
		return column;
	}
	public void book(int r,int c){
		ticket=true;
		row=r;
		column=c;
	}
	public void cancel(){
		ticket=false;
		row=-1;
		column=-1;
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
