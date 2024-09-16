package com.itheima.service;

import com.itheima.pojo.PageBean;

public interface EmpService {
    // 分页查询
    PageBean page(Integer page, Integer pageSize);
}
