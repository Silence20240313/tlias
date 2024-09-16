package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Slf4j    // 日志注解
@RequestMapping("/depts")
@RestController  // Controller层的注解
public class DeptController {

    // TODO 2.①用注解@Autowired在Controller中注入service对象（部门管理的Service实体类）
    //        接口名（DeptService），但实际上注入进来的是实体类对象（DeptServicelmpl），这是因为多态
      @Autowired
      // 注入对象语句
      private DeptService deptService;// 和前面保持一致  首字母小写

      // TODO 1.①定义一个方法,用于查询部门信息(方法的返回值:统一响应结果Result)
     //         ②指定当前接口的请求路径，限定请求方式为get(@GetMapping)
     //          当前方法的路径：访问这个路径才能调用list这个方法
     //         ③日志 调用info方法来输出日志（用这个注解@Slf4j，不用sout输出）
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        // TODO 2.①调用service查询部门数据（用@Autowired注解，注入service对象）
       //         ②在service接口里生成list方法，右击接口名--goto--实现类中，在service实现类里重写list方法，来查询全部的部门数据
        // 返回值是一个list类型的集合-部门
        // TODO 3.调用service层的list方法，获取数据，返回到list类型泛型为Dept的list中
        List<Dept> deptList = deptService.list();  // 注入进来的service对象，调用自己的list方法获取数据
        // TODO 4.调用Result的success方法，把获取的结果返回到前端
        return Result.success(deptList);// 响应成功
    }

    // 删除部门的方法
    @DeleteMapping("/{id}")  // {id}路径变量
    // 方法中声明参数接收路径变量
    // 获取路径id绑定给id参数
    public Result delete(@PathVariable Integer id){
        // {}参数占位符  最终id替换参数占位符
        log.info("根据id删除部门:{}",id);
        // 调用service来删除部门
        // 不需要获取返回值
        deptService.delete(id);
        return Result.success();
    }

    // 新增部门
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        // 调用service新增部门
        deptService.add(dept);
        return Result.success();
    }
}
