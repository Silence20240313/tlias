package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServicelmpl implements DeptService {


    // TODO 2.①注入部门管理的mapper接口
    @Autowired
    // 注入对象语句
    private DeptMapper deptMapper;// 和前面保持一致  首字母小写

    // TODO 1.在实现类中重写list方法
    //      2.①调用mapper操作方法（用@Autowired注解，注入mapper接口）
    //        ②在mapper接口里生成list方法
    //      3.调用mapper层的list方法来查询全部的部门信息,返回到list类型泛型为Dept的list中
    @Override
    public List<Dept> list() {
        List<Dept> list = deptMapper.list();
        return list;
    }

    @Override
    public void delete(Integer id) {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        // 补充基础属性 创建时间 更新时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }
}
