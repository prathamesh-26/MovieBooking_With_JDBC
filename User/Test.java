package User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Service.Administrator;
import Service.ConnectionClass;
import Service.Login;
import Service.Regs;


public class Test {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int choice=3;
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ WELCOME IN BOOK MY SHOW-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ ");
		do{
			System.out.println("1. Administrater\n2. User\n3. Exit\n\nEnter your choice : ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				Connection con  = ConnectionClass.getcon();
				PreparedStatement ps = con.prepareStatement("select * from admin");
				ResultSet rs = ps.executeQuery();
				System.out.println("Enter Username : ");
				String user = sc.next();
				boolean flag=false;
				while(rs.next()) {
					if(user.equals(rs.getString(1))) {
						System.out.println("Enter Password : ");
						String pass = sc.next();
						flag=true;
						if(pass.equals(rs.getString(2))) {
							System.out.println("Login Succesfully....");
							Administrator a = new Administrator();
							a.admin();
						}else
							System.out.println("Incorrect Password.....");					
					}	
				}
				if(flag==false)
				System.out.println("Incorrect Username.....");
				ps.close();
				con.close();
				break;
				
			case 2:	
				try {
					int choice1;
					do {
						System.out.println("1. Registration\n2. Login\n3. Exit\nEnter your Choice : ");
						choice1 = sc.nextInt();
						switch (choice1) {
						case 1:
							Regs r = new Regs();
							r.reg();
							r.print();
							break;
						case 2:
							Login l = new Login();
							l.login();
							break;
						}
					} while (choice1 != 3);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}while(choice!=3);
		
		
		
		
		
		
		
		
		
	}

}
