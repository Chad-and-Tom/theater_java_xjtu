package homework;

public class PersonDao {
	private static Person p[]=new Person[80];
	public void add(Person pe){
		for(int i=0;i<80;i++){
			if(p[i]==null) {p[i]=pe;break;}
		}
	}
	public int getLength(){
		int i;
		for(i=0;i<80;i++)
			if(p[i]==null) break;
		return i;
	}
	public boolean checkUsername(String u){
		for(int i=0;i<this.getLength();i++)
			if(u.equals(p[i].getUsername())) return false;
		return true;
		
	}
	public boolean checkPassword(String u1,String u2){
		int n;
		for(n=0;n<this.getLength();n++){
			if(u1.equals(p[n].getUsername())) break;
		};
		if(u2.equals(p[n].getPassword())) return true;
		return false;
	}
	public Person getPerson(String u){
		int n;
		for(n=0;n<this.getLength();n++){
			if(u.equals(p[n].getUsername())) break;
		};
		 return p[n];
	}
	
}
