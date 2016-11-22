package board.model;

import java.util.Date;

public class ArticleModel 
{
	private int id;
	private Date positing_date;
	private int read_count;
	private String writer_name;
	private String password;
	private String title;
	private String content;
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public Date getPositing_date() {
		return positing_date;
	}
	public void setPositing_date(Date positing_date) {
		this.positing_date = positing_date;
	}
	public int getRead_count() {
		return read_count;
	}
	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}
	public String getWriter_name() {
		return writer_name;
	}
	public void setWriter_name(String writer_name) {
		this.writer_name = writer_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArticleModel getModel()
	{
		return this;
	}
}
