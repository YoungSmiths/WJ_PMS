package com.wj.pms.controller;

import com.wj.pms.common.Result;
import com.wj.pms.common.enums.BusinessResponseCodeEnum;
import com.wj.pms.common.exception.BaseException;
import com.wj.pms.common.exception.ViewException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * 
 */
@RestController
@RequestMapping("api/uploadDownload")
public class UploadDownloadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadDownloadController.class);

    @Value("${uploadDir}")
    private String uploadDir;

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public Result uploadImage(@RequestParam(value = "file") MultipartFile file) throws RuntimeException, BaseException {
        if (file.isEmpty()) {
            throw new ViewException(BusinessResponseCodeEnum.FILE_NAME_IS_NULL, file);
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = uploadDir;
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            logger.info("上传成功后的文件路径未：" + filePath + fileName);
            return Result.success(fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.fail(BusinessResponseCodeEnum.FILE_UPLOAD_FAILED, null);
    }

    //文件下载相关代码
    @RequestMapping(value = "/downloadImage",method = RequestMethod.GET)
    public String downloadImage(String imageName,HttpServletRequest request, HttpServletResponse response) {
        logger.debug("the imageName is : "+imageName);
        String fileUrl = uploadDir+imageName;
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
           /* String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");*/
            /*File file = new File(realPath, fileName);*/
            File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + imageName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        return null;
    }

    /**
     * 多文件上传
     * @param files
     * @return
     * @throws RuntimeException
     */
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    public Result uploadFiles(@RequestParam(value = "file") MultipartFile[] files){
        StringBuffer result = new StringBuffer();
        try {
            for (int i = 0; i < files.length; i++) {
                if (files[i] != null) {
                    //调用上传方法
                    String fileName = executeUpload(files[i]);
                    result.append(fileName+";");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result.fail(BusinessResponseCodeEnum.FILE_UPLOAD_FAILED, null);
        }
        return Result.success(result.toString());
    }

    /**
     * 提取上传方法为公共方法
     * @param file
     * @return
     * @throws Exception
     */
    private String executeUpload(MultipartFile file)throws Exception{
        //文件后缀名
        String fileName = file.getOriginalFilename();
        //上传文件名
        //服务端保存的文件对象
        File serverFile = new File(uploadDir + fileName);
        // 检测是否存在目录
        if (!serverFile.getParentFile().exists()) {
            serverFile.getParentFile().mkdirs();
        }
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return fileName;
    }
}
