package board.jdbc;

import java.sql.*;

public class JdbcUtil 
{
	public static void close(Connection conn) throws SQLException
	{
		conn.close();
	}
	public static void close(Statement stmt) throws SQLException
	{
		stmt.close();
	}
	public static void close(ResultSet rs) throws SQLException
	{
		rs.close();
	}
}
