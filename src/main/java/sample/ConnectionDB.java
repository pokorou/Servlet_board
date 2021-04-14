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
			String sql = "insert into thread_table(title,name,message)value(?,?,?)";
			ps = db.prepareStatement(sql);
			ps.setString(1, Integer.toString(threadNumber));
			ps.setString(2, name);
			ps.setString(3, message);
			ps.executeUpdate();

			System.out.println("スレッド新規作成処理が成功しました。");
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

	public void newThread(String title, String name, String message) {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "insert into thread_table(title,name,message)value(?,?,?)";
			ps = db.prepareStatement("insert into thread_table (title,name,message) value (?,?,?)");
			ps.setString(1, title);
			ps.setString(2, name);
			ps.setString(3, message);
			ps.executeUpdate();

			System.out.println("スレッド新規作成処理が成功しました。");
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

			System.out.println("スレッドテーブルの抽出が成功しました。");

			while (rs.next()) {
				ThreadBean tb = new ThreadBean(rs.getString("title"), rs.getString("name"), rs.getString("message"));
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

	public List<CommentBean> selectAllComment() {
		Connection db = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CommentBean> list = new ArrayList<CommentBean>();
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/bulletin_board");
			db = ds.getConnection();
			String sql = "select * from comment_table";
			ps = db.prepareStatement(sql);
			rs = ps.executeQuery();

			System.out.println("コメントテーブルの抽出が成功しました。");

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
}