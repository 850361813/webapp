package com.baidu.fpd.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by zhaoxianghui on 2017/8/24.
 */
@Controller
@RequestMapping("fetch")
public class FetchController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "acc", method = RequestMethod.GET)
    @ResponseBody
    public void download(@RequestParam("date") String date, HttpServletResponse response) {

        String fileName = "order_info.zip";
        String filepath = "/Users/baidu/Documents/";

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition",
                    String.format("attachment; filename=%s", URLEncoder.encode(fileName, "UTF-8")));
            bos = new BufferedOutputStream(response.getOutputStream());
            bis = new BufferedInputStream(new FileInputStream(new File(filepath + fileName)));
            IOUtils.copy(bis, bos);
        } catch (Exception e) {
            logger.error("file download fail!", e);
        } finally {
            IOUtils.closeQuietly(bis);
            IOUtils.closeQuietly(bos);
        }

    }

    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(@RequestParam("imageFile") MultipartFile image, HttpServletRequest request) throws IOException
    {
        String path = request.getRealPath("/upload");
        request.setAttribute("name",image.getOriginalFilename());
        request.setAttribute("img","<img src='http://mn960mn.blog.163.com/blog/upload/"+image.getOriginalFilename()+"'></img>");
        FileCopyUtils.copy(image.getBytes(),new File(path+"/"+image.getOriginalFilename()));
        return "ok";
    }
}
