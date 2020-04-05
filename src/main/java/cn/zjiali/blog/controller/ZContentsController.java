package cn.zjiali.blog.controller;


import cn.zjiali.blog.service.IZContentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
@Controller
public class ZContentsController {

    private final IZContentsService izContentsService;

    public ZContentsController(IZContentsService izContentsService) {
        this.izContentsService = izContentsService;
    }

    @RequestMapping("/")
    public Mono<String> index(ConcurrentModel modelMap) {
        //展示8条记录
        izContentsService.getIndex(modelMap);
        return Mono.create(stringMonoSink -> stringMonoSink.success("index"));
    }

    @RequestMapping("/page/{num}")
    public Mono<String> page(ConcurrentModel modelMap, @PathVariable("num") int num) {
        izContentsService.page(modelMap, num);
        return Mono.create(stringMonoSink -> stringMonoSink.success("index"));
    }

    /**
     * 时间列表
     */
    @RequestMapping("/archive")
    public Mono<String> timeList(ConcurrentModel modelMap) {
        izContentsService.timeList(modelMap);
        return Mono.create(stringMonoSink -> stringMonoSink.success("archive"));
    }

}

