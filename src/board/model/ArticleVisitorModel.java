package board.model;

public class ArticleVisitorModel 
{
	private String guestname;
	private String password;
	private String message;
	
	public String getGuestname()
	{
		return guestname;
	}
	public void setGuestname(String guestname)
	{
		this.guestname = guestname;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public ArticleVisitorModel getModel()
	{
		return this;
	}
	
}
