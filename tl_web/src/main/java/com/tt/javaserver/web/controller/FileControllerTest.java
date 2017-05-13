package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.util.Md5Util;
import com.tt.javaserver.web.vo.AppVersion;
import com.tt.javaserver.web.vo.CurrentApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by GCL on 17/5/2.
 */
@Controller
@RequestMapping("/file")
public class FileControllerTest {

    private  static  final Logger LOGGER = LoggerFactory.getLogger(FileControllerTest.class);

    @Resource
    private AppFilesController appFilesController;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file,
                       HttpServletRequest request) throws IOException {
        if (file.getSize() == 0 || file.isEmpty()) {
        }

        String path = getPath(request);
        String originalFileName = file.getOriginalFilename();

        String md5 = Md5Util.getFileMD5String(file.getInputStream());
        String fileName = getFileName(originalFileName,md5);
        File dir = new File(path,fileName);
        fileOutput(file, dir);

        String type = file.getContentType();
        LOGGER.info("type====="+type);

        com.tt.javaserver.web.vo.File appFile = new com.tt.javaserver.web.vo.File();
        appFile.setName(fileName);
        appFile.setUrl(path);
        appFile.setMd5(md5);
        appFile.setSize(file.getSize());
        appFile.setType(3);
        appFile.setGzip(0);
        SimpleResult r =  appFilesController.saveUploadFile(appFile);
        LOGGER.info("fileSave==="+r.getCode());

    }

    /**
     * 输出文件到指定目录
     * @param file
     * @param dir
     */
    private void fileOutput(@RequestParam(value = "file", required = false) MultipartFile file, File dir) {
        if(!dir.exists()){
            dir.mkdirs();
        }else {
            LOGGER.info("file.isExist");
        }
        //MultipartFile自带的解析方法,将文件输出到指定路径下
        try {
            file.transferTo(dir);
        } catch (IOException e) {
            LOGGER.info("文件输出失败");
            e.printStackTrace();
        }
    }

    /**
     *
     * 组装文件存储路径  公司代码_公司名称/软件代码_软件名称/软件名称_软件版本
     * @param request
     * @return
     */
    private String getPath(HttpServletRequest request) {
        AppVersion appVersion = (AppVersion) request.getSession().getAttribute("curVersion");
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
        String companyDir = currentApp.getCompanyCode()+"_"+currentApp.getCompanyName();
        String appDir = currentApp.getAppCode()+"_"+currentApp.getAppName();
        String versionDir = currentApp.getAppName()+"_"+appVersion.getVersion();

        String path = request.getSession().getServletContext().getRealPath("upload")
                + File.separator+companyDir+File.separator+ appDir;//+File.separator+versionDir

        LOGGER.info("path==="+path);
        return path;
    }

    /**
     * 组装文件存储的文件名 文件名+MD5+文件后缀
     * @param originalFileName
     * @param md5
     * @return
     */
    private String getFileName(String originalFileName,String md5){
        LOGGER.info("originalFilename"+originalFileName);
        LOGGER.info("md5==="+md5);
        String fileName ;
        try{
            String prefixName= originalFileName.substring(0,originalFileName.lastIndexOf("."));
            String suffixName=originalFileName.substring(originalFileName.lastIndexOf(".")+1);
            fileName = prefixName+"_"+md5+"."+suffixName;
        }catch (Exception e){
            fileName = originalFileName+"_"+md5;
        }
        LOGGER.info("fileName==="+fileName);
        return fileName;
    }


    /**
     * 文件下载功能
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/down")
    public void down(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //模拟文件，myfile.txt为需要下载的文件
        String fileName = request.getSession().getServletContext().getRealPath("upload")+"/2.jpg";
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));
        //假如以中文名下载的话
        String filename = "下载文件.jpg";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();
    }



    /**
     * 需求：
     * 接收两个文件夹路径，把其中一个文件夹中(包含内容)
     * 拷贝到另一个文件夹中
     * @author Rocky
     *
     */
    /**
     * 分析：
     * 1，在目标文件夹中创建原文件夹
     * 2，获取文件夹中所有的文件或文件夹，存储在File数组中
     * 3，遍历数组
     * 4，如果是文件，就用IO流读写(只能读写文件，不能读写文件夹)
     * 5，如果是文件夹，就递归调用
     *
     * @param args
     * @throws IOException
     */
//    public static void main(String[] args) throws IOException {
////            File src = Test1.getDir();
////            File dest = Test1.getDir();
////            if(src.equals(dest)) {
////                System.out.println("目标文件夹是原文件夹的子文件夹");
////            } else {
////                copy(src,dest);
////            }
//    }

    /**
     * 把其中一个文件夹拷贝到另一个文件夹中
     * 1，返回值类型是void
     * 2，参数列表File src,File dest
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copy(File src, File dest) throws IOException {
        //1，在目标文件夹中创建原文件夹
        File newDir = new File(dest,src.getName());
        newDir.mkdir();
        //2，获取文件夹中所有的文件或文件夹，存储在File数组中
        File[] subFiles = src.listFiles();
        //3，遍历数组
        for (File subFile : subFiles) {
            //4，如果是文件，就用IO流读写(只能读写文件，不能读写文件夹)
            if(subFile.isFile()) {
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(subFile));
                BufferedOutputStream bos = new BufferedOutputStream(
                        new FileOutputStream(new File(newDir,newDir.getName())));

                int index;
                while((index = bis.read()) != -1) {
                    bos.write(index);
                }
                bis.close();
                bos.close();
                //5，如果是文件夹，就递归调用
            } else {
                copy(subFile,newDir);
            }
        }


    }

}
