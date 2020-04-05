package cn.zjiali.blog.controller;


import cn.zjiali.blog.service.IZContentsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(ModelMap modelMap) {
        //展示8条记录
        izContentsService.getIndex(modelMap);
        return "index";
    }

    @RequestMapping("/page/{num}")
    public String page(ModelMap modelMap, @PathVariable("num") int num) {
        izContentsService.page(modelMap, num);
        return "index";
    }

}

