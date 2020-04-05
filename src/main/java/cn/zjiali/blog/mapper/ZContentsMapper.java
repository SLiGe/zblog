package cn.zjiali.blog.mapper;

import cn.zjiali.blog.entity.ZContents;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zJiaLi
 * @since 2020-04-04
 */
public interface ZContentsMapper {

    @Select("SELECT DISTINCT YEAR ( create_time ) as dataYear FROM z_contents GROUP BY dataYear")
    List<String> selectYears();
}
