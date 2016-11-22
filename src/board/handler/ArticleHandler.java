package board.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ArticleHandler extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		process(req,resp);
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		process(req,resp);
	}
	
	private void process(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException
	{
		String handle = req.getParameter("service");
		
		switch(handle)
		{
			case "insert" :	 break;
			case "select" :	 break;
			case "delete" :	 break;
			case "update" :	 break;
		}
	}
}
