package cn.zjiali.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ZContents implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String content;

    private Integer order;

    private String author;

    private String summary;

    /**
     * 标签集合
     */
    private String tags;

    private LocalDateTime updateTime;
    private LocalDateTime createTime;

    private String createTimeStr;

    private int page;

    private int pageSize;
}
