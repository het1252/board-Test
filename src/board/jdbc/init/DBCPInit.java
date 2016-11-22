package board.jdbc.init;

import java.util.StringTokenizer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class DBCPInit extends HttpServlet
{
	public void init(ServletConfig config) throws ServletException
	{
		try
		{
			String driver = config.getInitParameter("jdbcdriver");
			StringTokenizer st = new StringTokenizer(driver,",");
			
			while(st.hasMoreElements())
			{
				String h = st.nextToken();
				Class.forName(h);
			}
			
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		}
		catch(Exception e)
		{
			throw new ServletException(e);
		}
	}
}
