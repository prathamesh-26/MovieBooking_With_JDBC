package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BookingDesk {
	static Scanner sc = new Scanner(System.in);
	PreparedStatement ps;
	ResultSet rs;

	
	public void bookTicket()throws Exception {
		Connection con = ConnectionClass.getcon();
		System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Today's Movie -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
		ps = con.prepareStatement("select * from movie");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4)+"\t"+rs.getString(5));
			}
		ps.close();
		ps = con.prepareStatement("insert into details(movieId,seats) values(?,?)");
		System.out.println("Enter Id to Book tickets : ");
		int id= sc.nextInt();
		ps.setInt(1,id);
		System.out.println("Enter how many Tickets you want book : ");
		ps.setInt(2,sc.nextInt());
		ps.execute();
		ps = con.prepareStatement("select * from movie where id=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4)+"\t"+rs.getString(5));
		}
		System.out.println("\nMovie Ticket Booked Succesfully.....");
		ps.close();
		con.close();
			}

	public void addMeal() throws Exception {
		System.out
				.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Today's Snacks -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
		Connection con = ConnectionClass.getcon();
		PreparedStatement ps = con.prepareStatement("select * from meal");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
			}
		int snackId;
		while (true) {
			System.out.println("Enter Id to book Snacks (0 to Exit) : ");
			snackId = sc.nextInt();
			if (snackId == 0)
				break;
			
			ps = con.prepareStatement("insert into details(mealId) values(?)");
			ps.setInt(1,snackId);
			ps.execute();
			ps.close();
			
				}
		ps = con.prepareStatement("select * from meal where id=?");
		ps.setInt(1, snackId);
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(3));
		}
		System.out.println("Snacks booked succesfully.....");
		con.close();
	}

	
	public void printDetails() throws Exception {
	    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Ticket Bill -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
	    Connection con = ConnectionClass.getcon();
	    int total=0;
	    ps = con.prepareStatement("select * from details");
		rs = ps.executeQuery();
		while(rs.next()) {
			PreparedStatement ps1 = con.prepareStatement("select * from movie");
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				if(rs.getInt(1)==rs1.getInt(1)) {
					total =rs1.getInt(3)*rs.getInt(2);
					System.out.println(rs1.getString(2)+"\t"+rs1.getInt(3));	
				}
			}
				PreparedStatement ps2 = con.prepareStatement("select * from meal");
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next()) {
					if(rs.getInt(3)==rs2.getInt(1)) {
						total +=rs2.getInt(4);
						System.out.println(rs2.getString(2)+"\t"+rs2.getInt(4));	
					}
				}
				
			
		}
		
		System.out.println("Total Bill = "+total);
		con.close();
	  
	}


	public void logOut() throws Exception{
		System.out.println(
				"-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_ Logged out succefully -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
	    Connection con = ConnectionClass.getcon();
		PreparedStatement ps2 = con.prepareStatement("delete from details");
		ps2.execute();
		ps2.close();
		con.close();
	}

	
}
