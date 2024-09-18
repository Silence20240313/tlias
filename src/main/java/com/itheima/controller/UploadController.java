package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    // 服务端接收文件的 MultipartFile
    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
       log.info("文件上传:{},{},{}",username,age,image);
       // 获取原始文件名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一的文件名 不能重复  --uuid（通用唯一识别码）
        int index = originalFilename.lastIndexOf("."); //取到.的位置的索引
        String extname = originalFilename.substring(index); // 取后缀名
        String newFileName = UUID.randomUUID().toString()+extname;// 取随机名字+后缀
        log.info("新的文件名:{}",newFileName);

       // 将文件存储在服务器的磁盘目录当中  C:\resource
        image.transferTo(new File("C:\\resource\\" + newFileName)); // 保存到
       return Result.success();

       // 1.取到文件原始名 2.取到.的索引 3.获取后缀名 4.系统起名字+后缀 5.保存到本地磁盘
    }
}
