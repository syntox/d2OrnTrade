package top.seacolo.util;

import java.util.List;

public class PageUtil<T> {

    private int pageNow = 1;    // 当前页数
    private int pageSize = 4;   // 每页显示记录的条数
    private int totalCount;     // 总的记录条数
    private int totalPageCount; // 总的页数
    private int startPos;       // 开始位置，从0开始
    private boolean hasFirst;   // 是否有首页
    private boolean hasPre;     // 是否有前一页
    private boolean hasNext;    // 是否有下一页
    private boolean hasLast;    // 是否有最后一页

    private List<T> lists;

    public PageUtil() {
    }

    public PageUtil(int totalCount, int pageNow) {
        this.totalCount = totalCount;
        this.pageNow = pageNow;
    }

    /**
     * 取得总页数
     * 总页数=总记录数/每页数据量
     */
    public int getTotalPageCount() {
        totalPageCount = getTotalCount() / getPageSize();
        return (totalCount % pageSize == 0) ? totalPageCount : totalPageCount + 1;
    }

    /**
     * 设置总页数
     */
    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * 得到当前页
     */
    public int getPageNow() {
        return pageNow;
    }

    /**
     * 设置当前页
     */
    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    /**
     * 得到每页数据量
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页数据量
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 得到总数据量
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * 设置总数据量
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 取得选择记录的初始位置
     */
    public int getStartPos() {
        return (pageNow - 1) * pageSize;
    }

    /**
     * 设置起始页
     */
    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    /**
     * 当前页是否是第一页，如果是第一页，则没有其他第一页
     * true 不是第一页
     * false  是第一页
     */
    public boolean isHasFirst() {
        return (pageNow == 1) ? false : true;
    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    /**
     * 是否有前一页，通过是否有第一页判断，有第一页说明有前一页
     * true    有前一页
     * false 没有前一页
     */
    public boolean isHasPre() {
        return isHasFirst() ? true : false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    /**
     * 是否有下一页
     * true    有下一页
     * false 没有下一页
     */
    public boolean isHasNext() {
        return isHasLast() ? true : false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 是否有尾页
     * true 不是尾页
     * false  是尾页
     */
    public boolean isHasLast() {
        return (pageNow == getTotalPageCount()) ? false : true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
