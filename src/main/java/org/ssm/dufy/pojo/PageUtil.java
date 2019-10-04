package org.ssm.dufy.pojo;

import java.lang.reflect.Field;
import java.util.List;

public class PageUtil {
	//总条数  数据库查询
	private int count;
	//当前页   页面传入
	private int curPage;
	//每页显示多少条 10
	private int pageRow=10;
	//总导航数  总条数%每页显示多少条==0?总条数/每页显示多少条:总条数/每页显示多少条+1
	private int navCount;
	//起始行 (当前页-1)*10
	private int startRow;
	//首页   1
	private int firstPage=1;
	//尾页  总导航数
	private int lastPage;
	//上一页   当前页-1>0?当前页-1:首页
	private int prevPage;
	//下一页   当前页+1<=尾页?当前页+1:尾页
	private int nextPage;
	//起始导航
	private int startNav;
	//结束导航
	private int endNav;
	//总数
	/*private List<T> rows;
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}*/
	public PageUtil(int count,int curPage){
		this.count=count;
		this.curPage=curPage;
		this.navCount=this.count%this.pageRow==0?this.count/this.pageRow:this.count/this.pageRow+1;
		this.startRow=(this.curPage-1)*10;
		this.lastPage=this.navCount;
		this.prevPage=this.curPage-1>0?this.curPage-1:this.firstPage;
		this.nextPage=this.curPage+1<=this.lastPage?this.curPage+1:this.lastPage;
		if(this.navCount<10){
			//10页以下的情况
			this.startNav=this.firstPage;
			this.endNav=this.lastPage;
		}else{
			if(this.curPage-6<=0){
				//靠近首页的情况
				this.startNav=this.firstPage;
				this.endNav=10;
			}else if(this.curPage+4>=this.navCount){
				//靠近尾页的情况
				this.startNav=this.navCount-9;
				this.endNav=this.navCount;
			}else{
				this.startNav=this.curPage-5;
				this.endNav=this.curPage+4;
			}
		}
	}
	/*public static void main(String[] args) throws Exception{
		PageUtil pageUtil=new PageUtil(77,5);
		Class clazz=pageUtil.getClass();
		Field[] fields=clazz.getDeclaredFields();
		for(Field field:fields){
			String fieldName=field.getName();
			Object value=field.get(pageUtil);
			System.out.println(fieldName+":"+value);
		}
	}*/
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getNavCount() {
		return navCount;
	}
	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartNav() {
		return startNav;
	}
	public void setStartNav(int startNav) {
		this.startNav = startNav;
	}
	public int getEndNav() {
		return endNav;
	}
	public void setEndNav(int endNav) {
		this.endNav = endNav;
	}
	
}
