package cn.zjiali.blog.service;

import cn.zjiali.blog.entity.ZContents;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
public interface IZContentsService extends IService<ZContents> {

    /**
     * 主页渲染
     */
    void getIndex(ModelMap modelMap);

    void page(ModelMap modelMap, int num);
}
