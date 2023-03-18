package studentlogin;


	
	import java.util.Scanner;
	public class main  {
		public static void main(String[] args){
			Scanner sc=new Scanner(System.in);
		stlogin sp=new stlogin();
		System.out.println("enter the choice" );
		System.out.println("1.students login" );
		System.out.println("2.admin login" );
		
		int choice=sc.nextInt();
				if(choice==1) {
					System.out.println("enter the studentname" );
					String u=sc.next();
					System.out.println("enter the regno" );
					int p=sc.nextInt();
					if(sp.logins(p,u)) {
						while(true) {
					
					System.out.println("welcome to  database" );
					System.out.println("1.VIEW STUDENTS DETAILS");
					System.out.println("2.UPDATE STUDENTS DETAILS");
					System.out.println("3.EXIT" );
					System.out.println("ENTER THE CHOICE" );
					int ch=sc.nextInt();
					switch(ch) {
					case 1:
						System.out.println("enter regno" );
						int rno=sc.nextInt();
						sp.selection(rno);
						break;
					case 2:
						System.out.println("enter the regno" );
						int rn=sc.nextInt();
						System.out.println("enter the name" );
						String nm=sc.next();
						int resu=sp.update( nm,rn);
						System.out.println((resu>0)?"inserted data":"not inserted data" );
						break;
					case 3:
						System.out.println("exit" );
						break;
					case 4:
						System.out.println((ch>3)?"invalid choice":"invalid choice " );
						break;
					}
					System.out.println("end of the records" );
				}}else {
					System.out.println("invalid regno" );
				}
					sc.close();
					} if (choice==2){
				
					System.out.println("enter the username" );
					String u=sc.next();
					System.out.println("enter the password" );
					String p=sc.next();
					if(sp.login(u,p)) {
						while(true) {
					System.out.println("welcome to  database" );
					System.out.println("1.ADD STUDENTS DETAILS\n 2.VIEW STUDENTS DETAILS\n");
					System.out.println("3.UPDATE STUDENTS DETAILS\n 4.DELETE STUDENTS DETAILS\n");
					System.out.println("5.EXIT" );	
					System.out.println("ENTER THE CHOICE" );
					int ch=sc.nextInt();
					switch(ch) {
					case 1:
						System.out.println("enter the regno" );
						int r=sc.nextInt();
						System.out.println("enter the name" );
						String n=sc.next();
						System.out.println("enter the dob" );
						String dob=sc.next();
						System.out.println("enter the gender" );
						String g=sc.next();
						System.out.println("enter the course" );
						String c=sc.next();
						System.out.println("enter the fees" );
						int f=sc.nextInt();
						int res=sp.insertion(r, n, dob, g, c, f);
						System.out.println(res>0?"inserted data":"not inserted data" );
						break;
					case 2:
						sp.select();
						break;
					case 3:
						System.out.println("enter the name" );
						String nm=sc.next();
						System.out.println("enter the regno" );
						int rn=sc.nextInt();
						int resu=sp.update(nm,rn);
						System.out.println(resu>0?"inserted data":"not inserted data" );
						break;
					case 4:
						System.out.println("enter the regno" );
						int rno=sc.nextInt();
						int result=sp.delete(rno);
						System.out.println(rno>0?"deleted data":"not deleted data" );
						break;
					case 5:
						System.out.println("exit" );
						break;
					}
					System.out.println("end of records" );
					
						}
					}else {
						System.out.println(choice>4?"invalid choice":"invalid choice" );
					}
					sc.close();
				}
				;
		}}



