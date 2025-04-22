package com.ybc.mapper;

import com.github.pagehelper.Page;
import com.ybc.dto.CategoryPageQueryDTO;
import com.ybc.entity.Category;
import com.ybc.result.PageResult;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    @Insert("insert into category(type, name, sort, status, create_time, update_time, create_user, update_user)" +
            " VALUES" +
            " (#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Category category);

    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    void update(Category category);

//    @Select("select * from category where type = #{type}")
    List<Category> selectByType(Integer type);
}
