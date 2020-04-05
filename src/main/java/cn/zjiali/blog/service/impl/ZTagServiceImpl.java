package cn.zjiali.blog.service.impl;

import cn.zjiali.blog.entity.ZContents;
import cn.zjiali.blog.entity.ZTag;
import cn.zjiali.blog.mapper.ZContentsMapper;
import cn.zjiali.blog.mapper.ZTagMapper;
import cn.zjiali.blog.service.IZTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ConcurrentModel;

import java.time.format.DateTimeFormatter;
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
public class ZTagServiceImpl implements IZTagService {

    private final ZContentsMapper zContentsMapper;
    private final ZTagMapper zTagMapper;

    @Autowired
    public ZTagServiceImpl(ZContentsMapper zContentsMapper, ZTagMapper zTagMapper) {
        this.zContentsMapper = zContentsMapper;
        this.zTagMapper = zTagMapper;
    }

    @Override
    public void getTagData(ConcurrentModel modelMap) {
        List<ZTag> tags = zTagMapper.list();
        Map<String, Object> dataMap = new HashMap<>();
        tags.forEach(tag -> {
            List<ZContents> zContents = zContentsMapper.list(null, null, tag.getTagValue());
            zContents.forEach(c -> c.setCreateTimeStr(c.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
            dataMap.put(tag.getTagName(), zContents);
        });
        modelMap.addAttribute("dataMap", dataMap);
    }
}
