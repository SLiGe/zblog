package cn.zjiali.blog.service.impl;

import cn.zjiali.blog.entity.ZContents;
import cn.zjiali.blog.mapper.ZContentsMapper;
import cn.zjiali.blog.service.IZContentsService;
import cn.zjiali.blog.util.CommonUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
@Service
public class ZContentsServiceImpl extends ServiceImpl<ZContentsMapper, ZContents> implements IZContentsService {

    @Override
    public void getIndex(ModelMap modelMap) {
        List<ZContents> list = list(Wrappers.<ZContents>lambdaQuery().orderByDesc(ZContents::getCreateTime).last(" limit 8"));
        modelMap.addAttribute("list", list);
        int count = count();
        modelMap.addAttribute("dataCount", count);
    }

    @Override
    public void page(ModelMap modelMap, int num) {
        int pageParam = CommonUtil.getPageParam(num, 8);
        String limitSql = " limit " + pageParam + ",8 ";
        List<ZContents> list = list(Wrappers.<ZContents>lambdaQuery().orderByDesc(ZContents::getCreateTime).last(limitSql));
        modelMap.addAttribute("list", list);
        int count = count();
        modelMap.addAttribute("dataCount", count);
    }
}
