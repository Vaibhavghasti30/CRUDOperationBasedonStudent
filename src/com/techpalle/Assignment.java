package com.techpalle;

import java.sql.*;

import java.util.Scanner;

public class Assignment {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		int num=1;
    for(int i=num; i<=5; i++)
    {
     System.out.println("Enter the Value");
      num = sc.nextInt();
      A a = new A();
     if(num==1);
    	 a.creating(); 
    	
     
     if(num==2);
     System.out.println("Inserting the value");
    	System.out.println("Enter the employe name");
    	String name = sc.next();
    	System.out.println("enter the salary");
    	int sal = sc.nextInt();
    	a.inserting(name,sal);
    	
     
     if(num==3);
         
    	 System.out.println("Updating the employe datails");
    	 System.out.println("Enter id");
    	 int id = sc.nextInt();
    	 System.out.println("enter name");
    	 String str = sc.next();
    	 System.out.println("enter salary");
    	 int s = sc.nextInt();
    	 a.updating(id, str, s); 
    	
     if(num==4);
     
    	 System.out.println("Deleting the details");
    	 System.out.println("Enter eid");
    	 int d = sc.nextInt();
    	 a.deleting(d);
    	
    if(num==5);
     
    	 System.out.println("Exit from the jdbc");
         
     if(num>5)
     {
    	 System.out.println("Enter the number between 1 to 5");
     }
     }
    }
}


class A
{
     
     Connection con = null;
     Statement s = null;
     PreparedStatement ps = null;
     
     
     public static String url = "jdbc:mysql://localhost:3306/exam";
     public static String username = "root";
     public static String password = "Admin";
     
     public void creating()
     {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);	
			s = con.createStatement();
			s.executeUpdate("create table emp(eid int primary key auto_increment," + "ename varchar(80) not null,esal int)");
		} 
    	 catch (ClassNotFoundException e)
    	 {
			e.printStackTrace();
		}
    	 catch(SQLSyntaxErrorException e2)
    	 {
    		 System.out.println("Table already Existed");
    	 }
    	 catch (SQLException e)
    	 {
			e.printStackTrace();
		}
    	 finally {
    		 try {
    			 if(s != null)
    			 {
    				 s.close();
    			 }
    			 if(con != null)
    			 {
    				 con.close();
    			 }
    		 }
    		
    		 catch (SQLException e)
        	 {
    			e.printStackTrace();
    		} 
    	 }
     }
     
     public void inserting(String ename,int esal)
     {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("insert into emp(ename,esal) values(?,?)");
			ps.setString(1, ename);
			ps.setInt(2, esal);
			ps.executeUpdate();
		} 
    	 catch (ClassNotFoundException e)
    	 {
			e.printStackTrace();
		}
    	 catch (SQLException e)
    	 {
			e.printStackTrace();
		}
    	 finally {
    		 try {
    			 if(ps != null)
    			 {
    				 ps.close();
    			 }
    			 if(con != null)
    			 {
    				 con.close();
    			 }
    		 }
    		 catch (SQLException e)
        	 {
    			e.printStackTrace();
    		} 
    	 }
    	 System.out.println("Details added succesfully");
     }
     public void updating(int id,String ename,int esal)
     {
    	 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
			ps = con.prepareStatement("update emp set ename=?,esal=? where eid=?");
			ps.setInt(1, id);
			ps.setString(2, ename);
			ps.setInt(3, esal);
			ps.executeUpdate();
		} 
    	 catch (ClassNotFoundException e)
    	 {
			e.printStackTrace();
		}
    	 catch (SQLException e)
    	 {
			e.printStackTrace();
		}
    	 finally {
    		 try {
    			 if(ps != null)
    			 {
    				 ps.close();
    			 }
    			 if(con != null)
    			 {
    				 con.close();
    			 }
    		 }
    		 catch (SQLException e)
        	 {
    			e.printStackTrace();
    		} 
    	 }
    	 System.out.println("Details updated succesfully");
     }
     public void deleting(int id)
 	{
 		try {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			con = DriverManager.getConnection(url, username, password);
 			ps = con.prepareStatement("delete from emp where eid=?");
 		    ps.setInt(1, id);
 			ps.executeUpdate();
 		} 
 		catch (ClassNotFoundException e)
 		{
 			e.printStackTrace();
 		} 
 		catch (SQLException e)
 		{
 			e.printStackTrace();
 		}
 		finally
 		{
 				try 
 				{
 					if(ps != null)
 					{
 					ps.close();
 					}
 					if(con != null)
 					{
 						con.close();
 				    }
 			}
 				 catch (SQLException e) 
 				 {
 					e.printStackTrace();
 				 }
 			}
 		System.out.println("Deleted the details from table");
 	}
     
 } 


     
	


