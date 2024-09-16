package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 部门管理
@Mapper
public interface DeptMapper {
    // TODO 2.往数据库中发送sql语句
    @Select("select * from dept")
    // TODO 1.生成list方法，查询全部部门数据
    List<Dept> list();// 查询的结果封装在list集合中

    // 根据Id删除部门
    @Delete("delete  from dept where id = #{id}")
    void delete(Integer id);

    // 新增部门信息
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void add(Dept dept);
}
