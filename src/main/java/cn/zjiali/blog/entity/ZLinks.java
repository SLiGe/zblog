package cn.zjiali.blog.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class ZLinks implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String linkName;

    private String linkAddress;

    private LocalDateTime updateTime;

    private LocalDateTime createTime;


}
