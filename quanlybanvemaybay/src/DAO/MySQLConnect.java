package DAO;
import DAO.*;
import DTO.*;
import FRM.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLConnect {

		private String host;
		private String username;
		private String password;
		private String database;
		
		private Connection connect=null;
		private Statement statement=null;
		private ResultSet result=null;
		
		public MySQLConnect() {}
		public MySQLConnect(String host,String username,String password,String database) 
		{
			this.host=host;
			this.username=username;
			this.password=password;
			this.database=database;
			
		}
		
		public void Connect()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://"+this.host+":3306/"+this.database;
				connect=DriverManager.getConnection(url,this.username,this.password);
			}
			catch(Exception e) 
			{
				JOptionPane.showMessageDialog(null,"Lỗi kết nối Database.");
			}
		}
		public void executeQuery(String query)
		{
			try {
				statement=connect.createStatement();
				result=statement.executeQuery(query);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Lỗi truy vấn dữ liệu từ database.");
			}
		}
		public void executeUpdate(String query)
		{
			try {
				statement=connect.createStatement();
				statement.executeUpdate(query);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Lỗi executeUpdate vào database.");
			}
		}
		
		public void close() 
		{
			try {
				if(result!=null)
					result.close();
				if(statement!=null)
					statement.close();
				if(connect!=null)
					connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getDatabase() {
			return database;
		}
		public void setDatabase(String database) {
			this.database = database;
		}
		public Connection getConnect() {
			return connect;
		}
		public void setConnect(Connection connect) {
			this.connect = connect;
		}
		public Statement getStatement() {
			return statement;
		}
		public void setStatement(Statement st) {
			this.statement = st;
		}
		public ResultSet getResult() {
			return result;
		}
		public void setResult(ResultSet rs) {
			this.result = rs;
		}
}
