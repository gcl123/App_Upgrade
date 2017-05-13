package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by GCL on 17/4/20.
 */
@Controller
@RequestMapping("/version")
public class AppVersionController extends BaseController {


    private static final Logger LOGGER = LoggerFactory.getLogger(AppVersionController.class);


    @Resource
    private AppService appService;

    @Resource
    private AppVersionService appVersionService;

    @Resource
    private  AppFilesService appFilesService;

    @Resource
    private FileService fileService ;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(AppVersion appVersion,HttpServletRequest request) {
        LOGGER.info("====add===="+appVersion);
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
        appVersion.setAppId(currentApp.getId());
        appVersion.setStatus(0);
        appVersion.setSetupScript(" ");
        LOGGER.info(""+appVersion);
        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appVersionService.insert(appVersion)>0) {
            //将当前版本 保存到session
            request.getSession().setAttribute("curVersion",appVersion);

            SimpleResult<Map> result = new SimpleResult<>(0, "插入版本成功");
            Map<String, Object> data = new HashMap<>();
            data.put("id", appVersion.getId());
            result.setData(data);
            return result;
        }else {
            return new SimpleResult(-1, "插入失败");
        }

    }


    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(AppVersion appVersion) {
        LOGGER.info("query===="+appVersion);

        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = appVersionService.selectTotal(appVersion);
        List<AppVersion> appVersionList = appVersionService.selectList(appVersion);
        if (total!=0 && appVersionList!= null) {
            SimpleResult<Map> result = new SimpleResult<>(0, "查询成功");
            Map<String, Object> data = new HashMap<>();
            data.put("total", total);
            data.put("appVersions",appVersionList);
            result.setData(data);
            return result;
        }else {
            return new SimpleResult(-1, "插入失败,该版本已存在");
        }

    }



    /**
     * 更新appVersion指令
     *
     * @param appVersion
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(AppVersion appVersion) {
        LOGGER.info("update============="+appVersion);
        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appVersionService.update(appVersion)>0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    /**
     * 删除
     *
     * @param
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(int  id) {
        LOGGER.info("delete============"+id);

        if (id == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if(appVersionService.deleteByInt(id)>0){
            LOGGER.info("删除success");
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }else {
            return new SimpleResult(-1, "删除失败");
        }
    }

    /**
     * 分页查询 将版本状态存储到session中
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody
    public Object selectPageUseDyc(Page<AppVersion> page, HttpServletRequest request) {

        LOGGER.info("appversion--selectPageUseDyc======page"+page);
        appVersionService.setStatus();
        try {
            CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
            page.setAppId(currentApp.getId());
            return appVersionService.selectPageUseDyc(page);
        }catch (Exception e){
            e.printStackTrace();

            return -1;
        }

    }

    /**
     * 根据id查询脚本
//     * @param appId
     * @return
     */
    @RequestMapping("/editScript")
    @ResponseBody
    public SimpleResult<Map> editScript(int versionId,HttpServletRequest request){

//        LOGGER.info("versionId"+versionId);
        LOGGER.info("============================================"+versionId);
        if(versionId == 0 ){
            return new SimpleResult(-2, "数据为空");
        }
        AppVersion curVer = appVersionService.select(versionId);
        request.getSession().setAttribute("curVersion",curVer);

        AppVersion curVersion = (AppVersion) request.getSession().getAttribute("curVersion");
//        LOGGER.info("curVersion==="+curVersion);
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
//        LOGGER.info("curAPP===" +currentApp);
        curVersion.setAppId(56);
        int appId =curVersion.getAppId();

        List<File> curVersionFiles = getAppVersionFiles(curVersion.getId());
        LOGGER.info("===============================================");
        LOGGER.info("curVersion"+curVersion);
        LOGGER.info("curVersionFile"+curVersionFiles);
        List<AppVersion> appVersionList = appVersionService.selectVersionByAppId(appId);//按照版本从小到大排列
        LOGGER.info("===============================================");

        if(curVersion!= null && appVersionList != null && curVersionFiles != null){
            Map<String, Object> data = new HashMap<>();
            SimpleResult<Map> result = new SimpleResult<>(0, "查询成功");

            Iterator<AppVersion> it = appVersionList.iterator();
            while(it.hasNext()){
                List<File> fileList1 = new LinkedList<>();
                AppVersion appVersion = it.next();
//                LOGGER.info("appVersion"+appVersion);
                if(curVersion.getVersion().compareTo(appVersion.getVersion()) > 0){
                    List<File> versionFiles = getAppVersionFiles(appVersion.getId());
                    Iterator<File> iterator = versionFiles.iterator();
                    while (iterator.hasNext()){
                        File file1 = iterator.next();
                        LOGGER.info("----------------------");
                        Iterator<File> curIt = curVersionFiles.iterator();
                        while (curIt.hasNext()){
                            File curFile = curIt.next();
                            if(curFile.equals(file1)){
                                LOGGER.info("equals");
                                fileList1.add(file1);
                                curIt.remove();
                            }
                        }
                    }
                    if(fileList1.size() > 0){
                        String name = "version"+appVersion.getVersion();
                        data.put(name,fileList1);
                    }
                }
            }
            data.put("version"+curVersion.getVersion(),curVersionFiles);
            result.setData(data);
            LOGGER.info("result ==="+result);
            return result;
            //                    2017-05-13 09:45:03 [INFO ] com.tt.javaserver.web.controller.AppVersionController
//                            - result ===SimpleResult{
//                              code=0, msg='查询成功',
//                            data={version1.0=[],
//                        version1.1=
//                                [File{id=254, appId=56,   version='1.1',
//                                File{id=255, appId=56,    version='1.1',
//                                File{id=260, appId=56,  version='1.1',
//                        }],
//                        version1.2=[
//                                 File{id=265, appId=56, version='1.2',
//                                File{id=266, appId=56, version='1.2',
//                                File{id=267, appId=56, version='1.2',
//                                    '}]}}
        }
        return new SimpleResult<>(-1,"此版本不存在");
    }


    /**
     * 通过版本Id 得到该版本对应的每个文件
     * @param versionId
     * @return
     */
    public List<File> getAppVersionFiles(int versionId){
        List<AppFiles> appFilesList = appFilesService.selectFilesByVersionId(versionId);

//        LOGGER.info("appFileList==="+appFilesList);

        List<File> fileList = new LinkedList<>();
        Iterator<AppFiles> it = appFilesList.iterator();
        while(it.hasNext()){
            AppFiles appFiles = it.next();
            int fileId = appFiles.getFileId();
            File file = fileService.select(fileId);
            fileList.add(file);
        }
        return fileList;
    }

    /**
     *
     * @param appVersion
     * @return
     */
    @RequestMapping("/saveScript")
    @ResponseBody
    public SimpleResult<Map> saveScript(AppVersion appVersion){

        LOGGER.info("saveScript========"+appVersion);
        return update(appVersion);
    }



    /**
     * 更改版本状态
     * 0-不可用
     * 1-可用
     * 9-测试中
     * @param appVersion
     * @return
     */
    @RequestMapping("/editStatus")
    @ResponseBody //如果返回json格式
    public SimpleResult<Map> editStatus(AppVersion appVersion,HttpServletRequest request){

        LOGGER.info("editStatus========"+appVersion);
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
        int appId = currentApp.getId();
        appVersion.setAppId(appId);
        if(appVersion.getStatus() == 1){
            App  app = appService.select(appId);
            AppVersion version = appVersionService.select(appVersion.getId());
            if(app.getLatestVersion().compareTo(version.getVersion()) < 0){
                app.setLatestVersion(version.getVersion());
                //app最新版本更行成功
                if(appService.update(app) > 0){
                    currentApp.setLatestVersion(version.getVersion());
                    request.getSession().setAttribute("curApp",currentApp);
                }
            }
        }
       return update(appVersion);
    }

    /**
     *
     * 设置最小可用版本
     * @param limitVersion 最小版本号
     * @param request
     * @return
     */
    @RequestMapping("/setMinVersion")
    @ResponseBody
    public SimpleResult setMinVersion(String limitVersion,HttpServletRequest request) {

        LOGGER.info("app--setMinVersion=====version=====:" + limitVersion );
        CurrentApp currentApp = (CurrentApp) request.getSession().getAttribute("curApp");
        int appId = currentApp.getId();
        if(appId == 0 || limitVersion == null){
            return new SimpleResult(-2,"数据为空");
        }
        App app = new App();
        app.setId(appId);
        app.setLimitVersion(limitVersion);
        LOGGER.info("app 设置成功");
        if(appService.update(app) > 0){
            LOGGER.info("app 最小本版本设置成功");
            if(appVersionService.setVersionStatus(appId,limitVersion) > 0){
                LOGGER.info("version 设置成功");
                return new SimpleResult(0,"设置最小版本成功");
            }
        }
        return new SimpleResult(-1,"设置最小版本失败");
    }


    /**
     * app版本升级
     * @param id  app 记录id
     * @param curVersion  当前使用版本
     * @return
     */
    @RequestMapping("/versionUpgrade")
    @ResponseBody
    public SimpleResult<Map> versionUpgrade(int id,String curVersion){

        LOGGER.info("versionUpgrade========"+id);
        LOGGER.info("versionUpgrade========"+curVersion);
        if(id == 0 && curVersion==null){
            return new SimpleResult(-2, "数据为空");
        }
        App app = appService.select(id);
        if(app != null &&  curVersion.compareTo(app.getLatestVersion()) < 0){
            AppVersion appVersion = appVersionService.selectVersion(app.getId(),app.getLatestVersion());
            if(appVersion != null){
                List<AppFiles> appFilesList = appFilesService.selectFilesByVersionId(appVersion.getId());
                if (appFilesList!= null){
                    List<File> fileList = new LinkedList<>();
                    Iterator it = appFilesList.iterator();
                    while (it.hasNext()){
                        AppFiles appFiles = (AppFiles) it.next();
                        int fileId = appFiles.getFileId();
                        File file = fileService.select(fileId);
                        fileList.add(file);
                    }
                    SimpleResult<Map> result = new SimpleResult<>(0, "查询成功");
                    Map<String, Object> data = new HashMap<>();
                    data.put("appVersion", appVersion);
                    data.put("versionFileList", fileList);
                    result.setData(data);
                    return result;
                }
            }else {
                return new SimpleResult<>(-1,"此版本不存在");
            }
        }
        return new SimpleResult<>(-1,"此软件不存在");
    }


}
