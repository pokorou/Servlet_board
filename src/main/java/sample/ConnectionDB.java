package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

public class ConnectionDB {
	public ConnectionDB() throws ServletException {
		Connection db = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
		Context context = new InitialContext();
		DataSource ds = 
		(DataSource)context.lookup("java:comp/env/jdbc/bulletin_board");
		db = ds.getConnection();
		
		ps=db.prepareStatement("SELECT * FROM thread_table");
		rs=ps.executeQuery();
		System.out.println("データベースへの接続に成功しました。");
		} catch (SQLException e) {
		System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
		throw new ServletException(e);
		} finally {
		try {
		if(db != null) {db.close();}
		} catch(Exception e) {}
		}
	}
}
