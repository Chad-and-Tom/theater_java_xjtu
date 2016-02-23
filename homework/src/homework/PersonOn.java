package homework;

public class PersonOn {
	private static Person pe[]=new Person[80];
	public void add(Person per){
		if(!this.checkOnline(per.getUsername())) 
	{
			for(int i=0;i<80;i++){
				if(pe[i]==null) {pe[i]=per;break;}
		}
		}
	}
	public int getLength(){
		int i;
		for(i=0;i<80;i++)
			if(pe[i]==null) break;
		return i;
	}
	public boolean checkOnline(String u){
		for(int i=0;i<80;i++)
			if(u.equals(pe[i].getUsername())) return true;
		return false;
	}
}
