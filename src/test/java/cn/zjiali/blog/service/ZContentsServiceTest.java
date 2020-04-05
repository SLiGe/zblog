package cn.zjiali.blog.service;

import cn.zjiali.blog.entity.ZContents;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Gary
 * @since 2020-04-05 16:19
 */
public class ZContentsServiceTest {

    @Test
    public void getTimeStr(){
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.print(format);
        ZContents zContents = new ZContents();
        zContents.setCreateTime(now);
        String createTimeStr = zContents.getCreateTimeStr();
        System.out.print(createTimeStr);
    }
}
