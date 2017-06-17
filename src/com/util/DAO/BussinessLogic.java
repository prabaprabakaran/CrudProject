package com.util.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.util.bean.*;
import com.util.conn.*;


public class BussinessLogic {
	public static int inserting(StudentOne stu) throws ParseException, SQLException{
		int i=0;
		Connection con=null;
		 PreparedStatement ps=null;
		try{
         ps=DbConnection.jdbc().prepareStatement("insert into student(stu_id,stu_name,sal) values (?,?,?)");
          ps.setInt(1,stu.getStu_id());  
          ps.setString(2,stu.getStu_name());  
          ps.setInt(3,stu.getSal());  
            
          i=ps.executeUpdate(); 
         if(ps!=null){
        	 ps.close();
         }
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return i;
		}
			
public static List<StudentOne> getList() throws SQLException, ClassNotFoundException{
	List<StudentOne>st=new ArrayList<StudentOne>();
	
	Statement sta=DbConnection.jdbc().createStatement();
	String view="select * from student";
    System.out.println("viewww");
    ResultSet re=sta.executeQuery(view);
    while(re.next()){
    	StudentOne stu=new StudentOne();
    	
    	stu.setStu_id(re.getInt("stu_id"));
    	stu.setStu_name(re.getString("stu_name"));
    	stu.setSal(re.getInt("sal"));
    	
    	 st.add(stu);
    	 
    }
   
	if(sta!=null){
		sta.close();
	}
	
if(DbConnection.jdbc()!=null){
	DbConnection.jdbc().close();
}
	
	return st;
	
}
public static int delete(StudentOne stu){  
    int status=0;  
    try{  
        Connection con=DbConnection.jdbc();
        PreparedStatement ps=con.prepareStatement("delete from student where stu_id=?");  
        ps.setInt(1,stu.getStu_id());  
        status=ps.executeUpdate();  
          
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
      
    return status;  
}  
public static int update(StudentOne stu) throws SQLException{  
    	Connection con=DbConnection.jdbc();
    	System.out.println(stu.getStu_name());
        PreparedStatement ps=con.prepareStatement(  
                     "update student set stu_name=?,sal=? where stu_id=?");
        ps.setString(1,stu.getStu_name());  
        ps.setInt(2,stu.getSal()); 
        ps.setInt(3,stu.getStu_id());  
      
    return ps.executeUpdate();
}  
public List<StudentOne> updateDatabase(int stu_id){
	List<StudentOne>st=new ArrayList<StudentOne>();
	ResultSet rs=null;
	try{
	Connection con=DbConnection.jdbc();
	Statement stmt=con.createStatement();
   String update="select * from student where stu_id="+stu_id+"";  
   rs=stmt.executeQuery(update);
   
    while(rs.next()){
    	StudentOne stu=new StudentOne();
    	stu.setStu_id(stu_id);
    	stu.setStu_name(rs.getString("stu_name"));
    	stu.setSal(rs.getInt("sal"));
    	st.add(stu);
    }
    
    con.close();  
}catch(Exception ex){ex.printStackTrace();}  
  
return st;
	}

public static void main(String[] args) throws SQLException {
	BussinessLogic bl=new BussinessLogic();
	 Connection con=DbConnection.jdbc();
	  System.out.println(con);	
}
}
