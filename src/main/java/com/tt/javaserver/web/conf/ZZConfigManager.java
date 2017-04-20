package com.tt.javaserver.web.conf;

import com.tt.javaserver.web.conf.gen.ConfigINIGenerator;
import com.tt.javaserver.web.conf.gen.IConfigChangeListener;
import com.tt.javaserver.web.conf.gen.Config;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * User: shangrenxiang
 * Date: 6/12/14
 * Time: 16:48
 */
public class ZZConfigManager {

    private static Logger LOGGER = LoggerFactory.getLogger(ZZConfigManager.class);

    /**
     * 通过注解(@ZZConfig)，确定配置类，通常在服务运行前启动
     *
     * @param confFileName 配置文件名称，如果文件不存在，则会新建
     * @param confPackage  需要扫描注解的package前缀
     *                     <p/>
     *                     例如:
     *                     ZZConfigManager.initializeConfig("~/etc/cocofsproxy.ini", "com.zz.javaserver.example.conf")
     */
    public static void initializeConfig(String confFileName, String confPackage) {
        File file = new File(confFileName);
        Class<?>[] configClasses = null;
        boolean needCreateFile = false;
        if (!file.exists()) {
            needCreateFile = true;
        }

        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
//		classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                .filterInputsBy(new FilterBuilder()
                        .includePackage("com.zz.javaserver.common.conf")   // 默认该包加入路径
                        .includePackage(confPackage)));
//				.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(confPackage))));

        Set<Class<?>> allClasses = reflections.getSubTypesOf(Object.class);

        List<Class<?>> classes = new ArrayList<Class<?>>();

        for (Class<?> cls : allClasses) {
            if (cls.isAnnotationPresent(ZZConfig.class)) {
                classes.add(cls);
            }
        }
        //classes.add(ZZGlobalConfig.class);//ZZGlobalConfig总是作为coco配置

        configClasses = new Class[classes.size()];
        classes.toArray(configClasses);

        if (needCreateFile) {
            file.getParentFile().mkdirs();
            ConfigINIGenerator.generateDefaultINI(confFileName, configClasses, null);
        }
        Config.initialize(confFileName);
        for (Class<?> configClass : configClasses) {
            Config.registerUpdatingListener(configClass);
            LOGGER.info("Add ZZConfig: " + configClass.getName());
        }
    }

    public static void addConfigChangeListener(Class clazz, String fieldName, IConfigChangeListener listener) {
        Map<String, IConfigChangeListener> m = Config.listenerMap.get(clazz);
        if (m == null) {
            m = new HashMap<String, IConfigChangeListener>();
            Config.listenerMap.put(clazz, m);
        }
        m.put(fieldName, listener);
    }

}
