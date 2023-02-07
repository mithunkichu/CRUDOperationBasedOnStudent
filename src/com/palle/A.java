package com.palle;

import java.sql.*;
import java.util.ArrayList;

public class A 
{
	
	private static final String url="jdbc:mysql://localhost:3306/jdbc";
	private static final String username="root";
	private static final String password="MithunKichu";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public void creating()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			con=DriverManager.getConnection(url,username,password);
			
			s=con.createStatement();
			
			String qry="create table student (sno int primary key auto_increment,sname varchar(50),sub varchar(40),email varchar(30) unique)";
			
			s.executeUpdate(qry);
		}
		catch(ClassNotFoundException e)
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
				if(s!=null)
				s.close();
				if(con!=null)
				con.close();
			}
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	public void inserting(String name,String subj,String mail)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			con=DriverManager.getConnection(url,username,password);
			String qry="insert into student(sname,sub,email) values(?,?,?)";
			ps=con.prepareStatement(qry);
			ps.setString(1, name);
			ps.setString(2, subj);
			ps.setString(3, mail);
			ps.executeUpdate();
		}
		catch(ClassNotFoundException e)
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
				if(ps!=null)
				ps.close();
				if(con!=null)
				con.close();
				
			}
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	public void delete(int num)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			con=DriverManager.getConnection(url,username,password);
			String qry="delete from student where sno=?";
			ps=con.prepareStatement(qry);
			
			ps.setInt(1, num);
			ps.executeUpdate();
		}
		catch(ClassNotFoundException e)
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
				if(ps!=null)
				ps.close();
				if(con!=null)
				con.close();
				
			}
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	public void update(int num,String name,String subj ,String mail)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			con=DriverManager.getConnection(url,username,password);
			String qry="update student set sname=?,sub=?,email=? where sno=?";
			ps=con.prepareStatement(qry);
			ps.setString(1, name);
			ps.setString(2, subj);
			ps.setString(3, mail);
			ps.setInt(4, num);
			ps.executeUpdate();
		}
		catch(ClassNotFoundException e)
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
				if(ps!=null)
				ps.close();
				if(con!=null)
				con.close();
				
			}
			catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	
	public void read()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			s=con.createStatement();
			String query="select sname from student";
			rs=s.executeQuery(query);
			while(rs.next())
			{
				System.out.println(rs.getString("sname"));
			}
			
			
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)
				rs.close();
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public ArrayList<Student> readAll()
	{
		ArrayList<Student> alStu=new ArrayList<Student>();
		Student stu=null;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			s=con.createStatement();
			String qry="select * from student";
			rs=s.executeQuery(qry);
			while(rs.next())
			{
				int n=rs.getInt("sno");
				String nam=rs.getString("sname");
				String sub=rs.getString("sub");
				String mail=rs.getString("email");
				stu=new Student(n, nam, sub, mail);
				alStu.add(stu);
				
			}
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return alStu;
	}
}
