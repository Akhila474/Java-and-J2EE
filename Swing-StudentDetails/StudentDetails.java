public class StudentDetails {
String name,usn,age,addr;double cgpa;
	StudentDetails(String n,String u,String a,String ad,double c)
	{
		name=n;
		usn=u;
		age=a;
		addr=ad;
		cgpa=c;
	}
	public String toString()
	{
		return "\nNAME : "+name+"\nUSN : "+usn+"\nAGE : "+age+"\nADDRESS : "+addr+"\nCGPA : "+cgpa+"\n";
	}
}
