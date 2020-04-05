package cn.zjiali.blog.mapper;

import cn.zjiali.blog.entity.ZContents;
import org.apache.ibatis.annotations.Param;
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

    List<ZContents> list(@Param("page") Integer page, @Param("pageSize") Integer pageSize, @Param("tag") String tag);

    int count();

    @Select("select id,title,summary,date_format( create_time, '%Y-%m-%d' ) AS createTimeStr  from z_contents where  YEAR(create_time) = #{year} order by `order`")
    List<ZContents> getTimeList(@Param("year") String year);
}
