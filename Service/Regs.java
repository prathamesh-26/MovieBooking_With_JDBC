package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.Scanner;

public class Regs {
	String name;
	String mail;
	long mob;
	public void reg() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name : ");
		name= sc.next();
		System.out.println("Enter Mail ID : ");
		mail = sc.next();
		System.out.println("Enter mobile no  : ");
		mob = sc.nextLong();
		
	}
	public void print() throws Exception{
 		String username = name+"<myshow>";
		String cl = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String ll = "qwertyuiopasdfghjklzxcvbnm";
		String no = "1234567890";
		String sc = "!@#$%^&*()-_=+{}|/][?><.:;";
		
		String add = cl+ll+no+sc;
		char[] pass = new char[8];
		Random rand = new Random();
		
		for(int i=0;i<pass.length;i++) {
			pass[i]=add.charAt(rand.nextInt(add.length()));
		}
		System.out.println("Username : "+username);
		System.out.println("PassWord : "+new String(pass));
		Connection con = ConnectionClass.getcon();
		PreparedStatement ps = con.prepareStatement("insert into login values (?,?)");
		ps.setString(1, username);
		ps.setString(2,new String(pass));
		ps.execute();
		ps.close();
		con.close();
	}
	
}
