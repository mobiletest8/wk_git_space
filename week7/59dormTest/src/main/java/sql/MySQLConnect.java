package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.PreparedStatement;

public class MySQLConnect {

	/**
	 * 链接数据库
	 * @param dataBase 库名
	 * @return
	 */
	private static Connection getConn(String dataBase) {
		
		Connection conn = null;
		String user = "admin";
		String password = "admin";
		String url = "jdbc:mysql://db.59temai.com:3306/" + dataBase;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭sql连接
	 * @param conn
	 */
	private static void connectClose(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询
	 * @param dataBase 库名
	 * @param sql sql语句
	 * @return
	 */
	private static ResultSet getAll(String dataBase,String sql){
		
		Connection conn = getConn(dataBase);
		PreparedStatement stat;
		ResultSet rs = null;
		
		try {
			
			stat = (PreparedStatement) conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectClose(conn);
		}
		
		return rs;
		
	}
}
