package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;

public class JDBCUtil {
	private static ComboPooledDataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
	}

	public static DataSource getDataSource() {
		return dataSource;
	}

	//得到连接对象
	public static Connection getConn() throws SQLException{
		return dataSource.getConnection();
	}
	
	   public static void release(Connection conn, Statement st, ResultSet rs) {
	        closeConn(conn);
	        closeSt(st);
	        closeRs(rs);
	    }

	    private static void closeRs(ResultSet rs) {
	        try {
	            if(rs != null) {
	                rs.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void closeSt(Statement st) {
	        try {
	            if(st != null) {
	                st.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void closeConn(Connection conn) {
	        try {
	            if(conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
