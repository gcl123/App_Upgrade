package com.tt.javaserver.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文件存储工具类
 * Created by wzy on 2016-12-14.
 */
public class FileUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

    public static String getRealFilePath(String path) {
        return path.replace("/", FILE_SEPARATOR).replace("\\", FILE_SEPARATOR);
    }


    public static Integer saveFile(byte[] fileData, String filePath) throws Exception {
        try {
            if (fileData != null) {
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(fileData);
                fos.flush();
                fos.close();
                return 0;
            }
            return -1;
        } catch (Exception e) {
            LOGGER.error("save file error:" + e.getMessage());
            throw new Exception("save file error");
        }

    }

    public static byte[] readFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        try {
            BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(file));
            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
            byte[] temp = new byte[1024];
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
            in.close();
            return out.toByteArray();
        } catch (Exception e) {
            LOGGER.error("read file error:" + e.getMessage());
            throw new Exception("read file error");
        }

    }

    //获取图片文件存放的根目录
    public static String getImgRootDir() {

//        String dir = ZZWebConfig.imgRootDir;
        String dir = "";
        File file1 = new File(dir);

        if (!file1.exists()) {
            file1.mkdirs();
        }
        dir = FileUtils.getRealFilePath(dir);
        if (!dir.endsWith(FileUtils.FILE_SEPARATOR)) {
            dir = dir + FileUtils.FILE_SEPARATOR;
        }
        return dir;
    }

    //获取当日图片文件存放的根目录
    public static String getTodayImgDir() {

        String dir = getImgRootDir();
        dir = dir + DateTimeUtils.format(new Date()) + FileUtils.FILE_SEPARATOR;
        File file1 = new File(dir);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        dir = FileUtils.getRealFilePath(dir);
        return dir;
    }

    /**
     * @param path
     */
    public static List<String> getChildDir(String path) {
        List<String> v = new ArrayList<>();
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files.length > 0) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        v.add(file2.getAbsolutePath());
                    }
                }
            }
        }
        return v;
    }

    public static void deleteAll(File file) {

        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteAll(files[i]);
                files[i].delete();
            }

            if (file.exists())         //如果文件本身就是目录 ，就要删除目录
                file.delete();
        }
    }

}
