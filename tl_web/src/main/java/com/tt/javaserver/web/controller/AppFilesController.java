package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.AppFiles;
import com.tt.javaserver.web.vo.AppVersion;
import com.tt.javaserver.web.vo.CurrentApp;
import com.tt.javaserver.web.vo.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by GCL on 17/4/20.
 */
@Controller
@RequestMapping("/appFiles")
public class AppFilesController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppFilesController.class);

    @Resource
    private AppFilesService appFilesService;
    @Resource
    private AppService appService;

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private FileService fileService;

    @Resource
    HttpServletRequest request;





//
//    @RequestMapping("/upload")
//    @ResponseBody
//    public SimpleResult<Map> fileUpload(MultipartFile file, HttpServletRequest request,
//                                        int appId,int versionId,String filePath){
//        String path = request.getSession().getServletContext().getRealPath("upload");
////        String path = "/Users/apple/IDEA/upload";
//        int  index  = filePath.indexOf('\\');
//        String fpath = filePath.substring(index);
//        path = path + fpath;
//        String fileName = file.getOriginalFilename();
//        java.io.File dir = new java.io.File(path,fileName);
//        System.out.println("path====="+path);
//        System.out.println("filename====="+fileName);
//
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        try {
//            //MultipartFile自带的解析方法
//            file.transferTo(dir);
//        } catch (IOException e) {
//            LOGGER.info("上传失败");
//        }
//
////        File appfile = new File();
////        appfile.setUrl(path);
////        LOGGER.info("appfile===upload"+appfile);
////
////        return appFileUpload(fileList);
//
//        return new SimpleResult<>(0,"ok");
//
//
//    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file,
                       HttpServletRequest request){
        if (file.getSize() == 0 || file.isEmpty()) {
        }
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        java.io.File dir = new java.io.File(path,fileName);

        System.out.println("path====="+path);
        System.out.println("filename====="+fileName);

        if(!dir.exists()){
            dir.mkdirs();
        }
        //MultipartFile自带的解析方法
        try {
            file.transferTo(dir);

        } catch (IOException e) {
            e.printStackTrace();
        }

        File appFile = new File();
        appFile.setUrl(path);
        appFile.setName(fileName);
    }



    /**
     * 添加软件 版本 文件
     *
     * @return
     */
    public  SimpleResult<Map> saveUploadFile(File appFile) {
        LOGGER.info("add=====list"+appFile);
        if (appFile == null ) {
            return new SimpleResult(-2, "数据为空");
        }
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
        int appId = currentApp.getId();
        appFile.setAppId(appId);

        AppVersion appVersion = (AppVersion) request.getSession().getAttribute("curVersion");
        int appVersionId = appVersion.getId();
        appFile.setVersion(appVersion.getVersion());
        int r = -1;
        if(isFirstUpload(appId)){
            //第一次上传软件
            r = newAppUpload(appFile,appVersionId);
        }else{
            //非第一次上传
            r = exitAppUpload(appFile,appVersionId);
        }
        if(r > 0){
            return  new SimpleResult<>(0, "插入成功");
        }
        return new SimpleResult(-1, "插入失败");
    }


    /**
     * 第一次上传软件,存储软件对应的每个文件
     */
    private int newAppUpload(File appFile,int appVersionId) {
        if(fileService.insert(appFile) > 0){
           return saveAppFiles(appFile.getId(),appVersionId);
        }
        return -1;
    }

    /**
     * 上传已有软件的新版本,存储软件的每个文件
     * @param appFile
     * @param appVersionId
     * @return
     */
    private int exitAppUpload(File appFile, int appVersionId) {
                try {
                    int id = fileService.selectIdByMd5(appFile);
                    if(id > 0){
                        //文件存在
                        return saveAppFiles(id,appVersionId);
                    }else {
                        //文件不存在
                        if(fileService.insert(appFile) > 0){
                            return saveAppFiles(appFile.getId(), appVersionId);
                        }
                    }
                }catch (Exception e ){
                    e.printStackTrace();
                    LOGGER.info("文件插入失败");
                }
        return -1;

    }

    /**
     * 是否是第一次上场软件
     * @param
     * @return
     */
    private boolean isFirstUpload(int id) {
        if (appVersionService.selectVersionCount(id) < 1){
            return true;
        }
        return false;
    }

    /**
     * 保存文件版本对应的文件
     * @param fileId
     * @param appVersionId
     * @return
     */

    private int saveAppFiles( int fileId,int appVersionId) {
        AppFiles appFiles = new AppFiles();
        appFiles.setAppVersionId(appVersionId);
        appFiles.setFileId(fileId);
        return  appFilesService.insert(appFiles);
    }

    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(AppFiles appFiles) {
        LOGGER.info("====add===="+appFiles);

        if (appFiles == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesService.insert(appFiles) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
            return result;
        }
        return new SimpleResult(-1, "插入失败,指令已存在");
    }

//    /**
//     * 查询对象
//     *
//     * @param appFiles
//     * @return
//     */
//    @RequestMapping("/queryVersion")
//    @ResponseBody
//    public SimpleResult<Map> queryVersion(AppFiles appFiles) {
//        LOGGER.info("=============");
//        LOGGER.info(appFiles.toString());
//
//        return appFilesService.selectVersionsByFileId(appFiles.getFileId());
//    }
//
//    @RequestMapping("/queryFiles")
//    @ResponseBody
//    public SimpleResult<Map> queryFiles(AppFiles appFiles) {
//        LOGGER.info("=============");
//        LOGGER.info(appFiles.toString());
//
//        return appFilesService.selectFilesByVersionId(appFiles.getAppVersionId());
//    }

    /**
     * 更新appFiles指令
     *
     * @param appFiles
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(AppFiles appFiles) {
        LOGGER.info("update============="+appFiles);

        if (appFiles == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesService.update(appFiles) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    /**
     * 删除
     *
     * @param appFiles
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(AppFiles appFiles) {
        LOGGER.info("delete============="+appFiles);
        if (appFiles == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesService.deleteByInt(appFiles.getAppVersionId()) > 0 ) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }



}
