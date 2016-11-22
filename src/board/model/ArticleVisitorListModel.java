package board.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArticleVisitorListModel {
		
	private List<ArticleVisitorModel> articleList;
	private int requestPage;
	private int totalPageCount;
	private int startRow;
	private int endRow;
		
	public ArticleVisitorListModel(){
		this(Collections.<ArticleVisitorModel> emptyList(), 0, 0, 0, 0);
	}
	public ArticleVisitorListModel(List<ArticleVisitorModel> articleList, int requestPageNumber, int totalPageCount, int startRow, int endRow){
		this.articleList=articleList;
		this.requestPage=requestPageNumber;
		this.totalPageCount=totalPageCount;
		this.startRow=startRow;
		this.endRow=endRow;
	}
		
	public List<ArticleVisitorModel> getArticleList(){
		return articleList;
	}
		
	public boolean isHasArticle(){
		return !articleList.isEmpty();
	}
		
	public int getRequestPage(){
		return requestPage;
	}
		
	public int getTotalPageCount(){
		return totalPageCount;
	}
		
	public int getStartRow(){
		return startRow;
	}
		
	public int getEndRow(){
		return endRow;
	}
}

