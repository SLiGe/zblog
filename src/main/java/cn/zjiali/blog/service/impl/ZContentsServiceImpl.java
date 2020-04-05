package cn.zjiali.blog.service.impl;

import cn.zjiali.blog.entity.ZContents;
import cn.zjiali.blog.mapper.ZContentsMapper;
import cn.zjiali.blog.service.IZContentsService;
import cn.zjiali.blog.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ConcurrentModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
@Service
public class ZContentsServiceImpl implements IZContentsService {

    private final ZContentsMapper zContentsMapper;

    @Autowired
    public ZContentsServiceImpl(ZContentsMapper zContentsMapper) {
        this.zContentsMapper = zContentsMapper;
    }


    @Override
    public void getIndex(ConcurrentModel modelMap) {
        List<ZContents> list = zContentsMapper.list(1, 8, null);
        modelMap.addAttribute("list", list);
        int count = zContentsMapper.count();
        modelMap.addAttribute("dataCount", count);
    }

    @Override
    public void page(ConcurrentModel modelMap, int num) {
        int pageParam = CommonUtil.getPageParam(num, 8);
        List<ZContents> list = zContentsMapper.list(pageParam, 8, null);
        modelMap.addAttribute("list", list);
        int count = zContentsMapper.count();
        modelMap.addAttribute("dataCount", count);
    }

    @Override
    public void timeList(ConcurrentModel modelMap) {
        List<String> years = zContentsMapper.selectYears();
        Map<String, Object> dataMap = new HashMap<>();
        years.forEach(year -> {
            List<ZContents> list = zContentsMapper.getTimeList(year);
            dataMap.put(year, list);
        });
        modelMap.addAttribute("dataMap", dataMap);
    }
}
