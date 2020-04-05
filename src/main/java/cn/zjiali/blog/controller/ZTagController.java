package cn.zjiali.blog.controller;


import cn.zjiali.blog.service.IZTagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
@Controller
public class ZTagController {

    private final IZTagService izTagService;

    public ZTagController(IZTagService izTagService) {
        this.izTagService = izTagService;
    }


    @RequestMapping("/blog/tags")
    public Mono<String> tags(ConcurrentModel modelMap){
        izTagService.getTagData(modelMap);
        return Mono.create(stringMonoSink -> stringMonoSink.success("tags"));
    }


}

