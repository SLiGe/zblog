package cn.zjiali.blog.service;

import cn.zjiali.blog.entity.ZContents;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
public interface IZContentsService  {

    /**
     * 主页渲染
     */
    void getIndex(ConcurrentModel modelMap);

    void page(ConcurrentModel modelMap, int num);

    void timeList(ConcurrentModel modelMap);

}
