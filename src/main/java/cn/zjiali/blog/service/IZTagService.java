package cn.zjiali.blog.service;

import org.springframework.ui.ConcurrentModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
public interface IZTagService  {

    void getTagData(ConcurrentModel modelMap);
}
