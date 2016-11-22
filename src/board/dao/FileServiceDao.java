package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import board.jdbc.JdbcUtil;
import board.model.ArticleFileModel;

public class FileServiceDao 
{
	private static FileServiceDao instants = new FileServiceDao();
	
	public FileServiceDao getInstant()
	{
		return instants;
	}
	
	public void insert(Connection conn, ArticleFileModel filemodel,int article_id) throws SQLException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = conn.prepareStatement("insert into pds_item(article_id,filename,realpath,filesize) values(?,?,?,?)");
			pstmt.setInt(1, article_id);
			pstmt.setString(2, filemodel.getFilename());
			pstmt.setString(3, filemodel.getRealpath());
			pstmt.setLong(4, filemodel.getFilesize());
			pstmt.execute();
		}
		finally
		{
			pstmt.close();
		}
	}
	
	public List<ArticleFileModel> select(Connection conn, int first,int last) throws SQLException
	{
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conn.prepareStatement("select * from article order by article desc limit ?, ?");
			pstmt.setInt(1, first+1);
			pstmt.setInt(2, last-first+1);
			
			return makeArticleList(pstmt.executeQuery());
		}
		finally
		{
			JdbcUtil.close(pstmt);
		}
	}
	
	public void delete(Connection conn,int article_id) throws SQLException
	{
		Statement stmt = null;
		try
		{
			stmt = conn.createStatement();
			stmt.execute("delete from article where article_id="+article_id);
		}
		finally
		{
			JdbcUtil.close(stmt);
		}
	}
	
	public void update(Connection conn,ArticleFileModel article) throws SQLException
	{
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt=conn.prepareStatement("update article set title=?, content=? where article_id=?");
			
		}
		finally
		{
			JdbcUtil.close(pstmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int articleId)throws SQLException
	{
		PreparedStatement pstmt=null;
		try
		{
			pstmt=conn.prepareStatement("update article set read_count=read_count+1 where article_id=?");
			pstmt.setInt(1, articleId);
			pstmt.executeUpdate();
		}
		finally
		{
			JdbcUtil.close(pstmt);
		}
	}
	
	private List<ArticleFileModel> makeArticleList(ResultSet rs) throws SQLException
	{
		ArticleFileModel model = new ArticleFileModel();
		List<ArticleFileModel> list = new ArrayList<ArticleFileModel>();
		
		while(rs.next())
		{
			
			
			list.add(model);
		}
		return list;
	}
	
	public int getSelectCount(Connection conn) throws SQLException
	{
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select (*) from article");
			rs.next();
			return rs.getInt(1);
		}
		finally
		{
			JdbcUtil.close(stmt);
		}
	}
}
