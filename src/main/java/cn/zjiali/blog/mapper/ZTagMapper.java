package cn.zjiali.blog.mapper;

import cn.zjiali.blog.entity.ZTag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
public interface ZTagMapper {

    @Select("select id,tag_name,tag_value from z_tag")
    List<ZTag> list();
}
