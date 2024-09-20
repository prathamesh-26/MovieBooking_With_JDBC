package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Login {
	
	public void login() throws Exception{
		Scanner sc = new Scanner(System.in);
		Connection con  = ConnectionClass.getcon();
		PreparedStatement ps = con.prepareStatement("select * from login");
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
					BookingDesk desk = new BookingDesk();
					try {
						while (true) {
							System.out.println("\n1. Book Ticket");
							System.out.println("2. Add Meal");
							System.out.println("3. Print Details");
							System.out.println("4. Log Out");
							System.out.print("\nEnter your choice: ");
							int choice = sc.nextInt();
							switch (choice) {
							case 1:
								desk.bookTicket();
								break;
							case 2:
								desk.addMeal();
								break;
							case 3:
								desk.printDetails();
								break;
							case 4:
								desk.logOut();
								return;
							default:
								System.out.println("Invalid choice. Try again.");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

				}else
					System.out.println("Incorrect Password.....");					
			}
				
		}
		if(flag==false)
		System.out.println("Incorrect Username.....");
		ps.close();
		con.close();
	}
}
