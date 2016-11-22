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
import board.model.ArticleModel;

public class CommentServiceDao
{
	private static CommentServiceDao instants = new CommentServiceDao();
	
	public CommentServiceDao getInstant()
	{
		return instants;
	}
	public void insert(Connection conn, ArticleModel articlemodel) throws SQLException
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = conn.prepareStatement("insert into article(positing_date,read_count,writer_name,password,title,content) values(?,0,?,?,?,?)");
			pstmt.setTimestamp(1, new Timestamp(articlemodel.getPositing_date().getTime()));
			pstmt.setString(2, articlemodel.getWriter_name());
			pstmt.setString(3, articlemodel.getPassword());
			pstmt.setString(4, articlemodel.getTitle());
			pstmt.setString(5, articlemodel.getContent());
			rs = pstmt.executeQuery();
		}
		finally
		{
			pstmt.close();
		}
	}
	
	public List<ArticleModel> select(Connection conn, int first,int last) throws SQLException
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
	
	public void update(Connection conn,ArticleModel article) throws SQLException
	{
		PreparedStatement pstmt = null;
		
		try
		{
			pstmt=conn.prepareStatement("update article set title=?, content=? where article_id=?");
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setInt(3, article.getId());
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
	
	private List<ArticleModel> makeArticleList(ResultSet rs) throws SQLException
	{
		ArticleModel model = new ArticleModel();
		List<ArticleModel> list = new ArrayList<ArticleModel>();
		
		while(rs.next())
		{
			model.setId(rs.getInt("article_id"));
			model.setContent(rs.getString("content"));
			model.setPassword(rs.getString("password"));
			model.setPositing_date(rs.getDate("date"));
			model.setRead_count(rs.getInt("read_count"));
			model.setTitle(rs.getString("title"));
			model.setWriter_name(rs.getString("writer_name"));
			
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
