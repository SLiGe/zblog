package cn.zjiali.blog.util;

/**
 * @author Gary
 * @since 2020-04-04 22:51
 */
public interface CommonUtil {

    /**
     * (curPage-1)*pageSize,pageSize
     */
    static int getPageParam(int currentPage, int pageSize) {
        return (currentPage - 1) * pageSize;
    }
}
