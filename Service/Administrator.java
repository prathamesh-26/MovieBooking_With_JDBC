package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Administrator {
	public void admin() throws Exception {
		int choice=0;
		Scanner sc = new Scanner(System.in);
		Connection con = ConnectionClass.getcon();
		PreparedStatement ps;
		do {
			System.out.println("1. Add Movie\n2. Add Snacks\n3. Update Movie\n4. Update Snacks\n5.Delete Movie\n6.Delete Snacks\n7. Exit\n\nEnter your Choice : ");
			choice = sc.nextInt();
			switch(choice) {
			case 1: 
				String insertMovie = "insert into movie values(?,?,?,?,?)";
				ps = con.prepareStatement(insertMovie);
				System.out.println("Enter Id : ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter name : ");
				ps.setString(2, sc.next());
				System.out.println("Enter Price : ");
				ps.setInt(3, sc.nextInt());
				System.out.println("Enter Rating : ");
				ps.setFloat(4, sc.nextFloat());
				System.out.println("Enter Gener : ");
				ps.setString(5, sc.next());
				ps.execute();
				ps.close();
				break;
				
			case 2:
				String insertSnack = "insert into meal values(?,?,?,?)";
				ps = con.prepareStatement(insertSnack);
				System.out.println("Enter Id : ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter name : ");
				sc.nextLine();
				ps.setString(2, sc.nextLine());
				System.out.println("Enter Description : ");
				ps.setString(3, sc.nextLine());
				System.out.println("Enter Price : ");
				ps.setInt(4, sc.nextInt());
				ps.execute();
				ps.close();
				break;
				
			case 3:
				ps = con.prepareStatement("update movie set id=?,name=?,price=?,rating=?,gener=? where id=?");
				System.out.println("Enter id that movie can Update you : ");
				ps.setInt(6,sc.nextInt());
				System.out.println("Enter new id : ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter  new Name : ");
				sc.nextLine();
				ps.setString(2, sc.nextLine());
				System.out.println("Enter new Price : ");
				ps.setInt(3, sc.nextInt());
				System.out.println("Enter new Rating : ");
				ps.setFloat(4, sc.nextFloat());
				System.out.println("Enter new Gener : ");
				sc.nextLine();
				ps.setString(5, sc.nextLine());
				ps.execute();
				ps.close();
				System.out.println("Succesfully Done.....");
				break;
				
			case 4:
				ps = con.prepareStatement("update meal set id=?,name=?,descp=?,price=? where id=?");
				System.out.println("Enter id that Snack can Update you : ");
				ps.setInt(5,sc.nextInt());
				System.out.println("Enter new Id : ");
				ps.setInt(1, sc.nextInt());
				System.out.println("Enter  new Name : ");
				sc.nextLine();
				ps.setString(2, sc.nextLine());
				System.out.println("Enter new Description : ");
				ps.setString(3, sc.nextLine());
				System.out.println("Enter new Price : ");
				ps.setInt(4, sc.nextInt());
				ps.execute();
				ps.close();
				System.out.println("Succesfully Done.....");
				break;
				
			case 5:
				ps = con.prepareStatement("delete from movie where id=?");
				System.out.println("Enter id to delete Movie : ");
				ps.setInt(1, sc.nextInt());
				ps.execute();
				System.out.println("Succesfully Done.....");
				ps.close();
				break;
				
			case 6:
				ps = con.prepareStatement("delete from meal where id=?");
				System.out.println("Enter id to delete Snack : ");
				ps.setInt(1, sc.nextInt());
				ps.execute();
				System.out.println("Succesfully Done.....");
				ps.close();
				break;
			}
		}while(choice!=7);
	}
}
