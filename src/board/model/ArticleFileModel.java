package board.model;

public class ArticleFileModel 
{
	private String filename;
	private Long filesize;
	private String realpath;
	
	public String getFilename() 
	{
		return filename;
	}
	
	public void setFilename(String filename) 
	{
		this.filename = filename;
	}
	
	public Long getFilesize() {
		return filesize;
	}
	
	public void setFilesize(Long filesize) 
	{
		this.filesize = filesize;
	}
	
	public String getRealpath() {
		return realpath;
	}
	
	public void setRealpath(String realpath) 
	{
		this.realpath = realpath;
	}
	
	public ArticleFileModel getModel()
	{
		return this;
	}
}
