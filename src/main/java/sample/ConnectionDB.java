package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionDB {
	public void newComment(int threadNumber, String name, String message) {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "insert into comment_table(threadNumber,name,message)value(?,?,?)";
			ps = db.prepareStatement(sql);
			ps.setInt(1, threadNumber);
			ps.setString(2, name);
			ps.setString(3, message);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
			System.out.println("その他のエラー");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e) {
			}
		}
	}

	public int newThread(String title, String name, String message) {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int autoIncrementKey = 0;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "insert into thread_table(title,name,message)value(?,?,?)";
			ps = db.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, message);
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			 if(rs.next()){
	             autoIncrementKey = rs.getInt(1);
	         }
			
		} catch (SQLException e) {
			System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
			System.out.println("その他のエラー");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}

			} catch (Exception e) {
			}
		}
		return  autoIncrementKey;
	}

	public List<ThreadBean> selectAllThread() {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ThreadBean> list = new ArrayList<ThreadBean>();
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "select * from thread_table";
			ps = db.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ThreadBean tb = new ThreadBean(Integer.parseInt(rs.getString("Id")),rs.getString("title"), rs.getString("name"), rs.getString("message"));
				list.add(tb);
			}

		} catch (SQLException e) {
			System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
			System.out.println("その他のエラー");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}

			} catch (Exception e) {
			}
		}
		return list;
	}

	public List<CommentBean> selectCommentOfThis(int threadNumber) {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CommentBean> list = new ArrayList<CommentBean>();
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "select * from comment_table where threadNumber=?";
			ps = db.prepareStatement(sql);
			ps.setInt(1, threadNumber);
			rs = ps.executeQuery();
			while (rs.next()) {
				CommentBean cb = new CommentBean(Integer.parseInt(rs.getString("threadNumber")), rs.getString("name"),
						rs.getString("message"));
				list.add(cb);
			}

		} catch (SQLException e) {
			System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
			System.out.println("その他のエラー");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}

			} catch (Exception e) {
			}
		}
		return list;
	}
	public List<ThreadBean>searchThread(String searchWord){
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ThreadBean> list = new ArrayList<ThreadBean>();
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "select * from thread_table where title like ?";
			ps = db.prepareStatement(sql);
			ps.setString(1, "%"+searchWord+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				ThreadBean tb= new ThreadBean(rs.getInt("id"),rs.getString("title"),rs.getString("name") ,rs.getString("message"));
				list.add(tb);
			}

		} catch (SQLException e) {
			System.out.println("データベースアクセスエラーが発生した。");
		} catch (Exception e) {
			System.out.println("その他のエラー");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (db != null) {
					db.close();
				}

			} catch (Exception e) {
			}
		}
		return list;
		
	}
}