//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tt.javaserver.web.conf.gen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class Config {
    public static String configurationFile = null;
    private static Object configMutex = new Object();
    private static Set<Class<?>> allConfigs = new HashSet();
    private static boolean running = false;
    private static Properties prop;
    private static long lastUpdated = 0L;

    public static Map<Class, Map<String, IConfigChangeListener>> listenerMap = new HashMap<Class, Map<String, IConfigChangeListener>>();

    public Config() {
    }

    public static void registerUpdatingListener(Class<?> clazz) {
        boolean updating = false;
        Object var2 = configMutex;
        synchronized (configMutex) {
            if (clazz != null && !allConfigs.contains(clazz)) {
                allConfigs.add(clazz);
                updating = true;
            }
        }

        if (updating && prop != null) {
            updateAConfigClass(prop, clazz);
        }

    }

    public static void initialize() {
        initialize((String) null);
    }

    public static void initialize(final String iniPath) {
        if (!running) {
            running = true;
            updateFromConfiguration(iniPath);
            Thread thread = new Thread("Configuration Monitor") {
                public void run() {
                    Config.lastUpdated = 0L;

                    while (Config.running) {
                        int i = 0;

                        while (true) {
                            if (i < 10) {
                                try {
                                    Thread.sleep(1000L);
                                } catch (InterruptedException var3) {
                                    var3.printStackTrace();
                                }

                                if (Config.running) {
                                    ++i;
                                    continue;
                                }
                            }

                            if (Config.running) {
                                Config.updateFromConfiguration(iniPath);
                            }
                            break;
                        }
                    }

                }
            };
            thread.setDaemon(true);
            thread.start();
        }
    }

    public static boolean switchConfig(String iniPath) {
        if (running) {
            running = false;
            lastUpdated = 0L;

            try {
                Thread.sleep(2000L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }

            initialize(iniPath);
            return true;
        } else {
            initialize(iniPath);
            return false;
        }
    }

    private static void notifyListener(IConfigChangeListener listener, Object newValue) {
        if (listener != null) {
            listener.fieldChanged(newValue);
        }
    }

    private static void updateAConfigClass(Properties prop, Class<?> clz) {
        if (clz != null) {
            Field[] fields = clz.getFields();

            for (int e = 0; e < fields.length; ++e) {
                Field f = fields[e];
                if (f != null) {
                    int modifiers = f.getModifiers();
                    if ((modifiers & 5) != 0 && (modifiers & 8) != 0 && (modifiers & 16) == 0) {
                        String name = f.getName();
                        String p = prop.getProperty(name);
                        if (p != null) {
                            p = p.replaceAll("(^ +)|( +$)", "");
                            if (p.length() != 0) {
                                Class type = f.getType();
                                IConfigChangeListener listener = null;
                                Map<String, IConfigChangeListener> fieldLis = listenerMap.get(clz);
                                if (fieldLis != null) {
                                    listener = fieldLis.get(name);
                                }

                                try {
                                    if (type == Integer.TYPE) {
                                        Integer t = Integer.parseInt(p);
                                        f.setInt(clz, t);
                                        notifyListener(listener, t);
                                    } else if (type == String.class) {
                                        f.set(clz, p);
                                        notifyListener(listener, p);
                                    } else if (type == Boolean.TYPE) {
                                        Boolean t = Boolean.parseBoolean(p);
                                        f.setBoolean(clz, t);
                                        notifyListener(listener, t);
                                    } else if (type == Long.TYPE) {
                                        Long t = Long.parseLong(p);
                                        f.setLong(clz, t);
                                        notifyListener(listener, t);
                                    } else if (type == String[].class) {
                                        Object t = p.split("\\s*;\\s*");
                                        f.set(clz, t);
                                        notifyListener(listener, t);
                                    } else {
                                        String[] e1;
                                        int j;
                                        if (type == int[].class) {
                                            e1 = p.split("\\s*;\\s*");
                                            int[] var19 = (int[]) null;
                                            if (e1 != null) {
                                                var19 = new int[e1.length];

                                                for (j = 0; j < e1.length; ++j) {
                                                    if (e1[j] != null) {
                                                        try {
                                                            var19[j] = Integer.parseInt(e1[j]);
                                                        } catch (Exception var16) {
                                                            var16.printStackTrace();
                                                        }
                                                    }
                                                }
                                            }

                                            f.set(clz, var19);
                                            notifyListener(listener, var19);
                                        } else if (type != long[].class) {
                                            if (type == Double.TYPE) {
                                                f.setDouble(clz, Double.parseDouble(p));
                                                notifyListener(listener, Double.parseDouble(p));
                                            } else if (type == Float.TYPE) {
                                                f.setFloat(clz, Float.parseFloat(p));
                                                notifyListener(listener, Float.parseFloat(p));
                                            } else if (type == Short.TYPE) {
                                                f.setShort(clz, Short.parseShort(p));
                                                notifyListener(listener, Short.parseShort(p));
                                            } else if (type == Byte.TYPE) {
                                                f.setByte(clz, Byte.parseByte(p));
                                                notifyListener(listener, Byte.parseByte(p));
                                            } else if (type == Character.TYPE) {
                                                f.setChar(clz, p.charAt(0));
                                                notifyListener(listener, p.charAt(0));
                                            }
                                        } else {
                                            e1 = p.split("\\s*;\\s*");
                                            long[] ls = (long[]) null;
                                            if (e1 != null) {
                                                ls = new long[e1.length];

                                                for (j = 0; j < e1.length; ++j) {
                                                    if (e1[j] != null) {
                                                        try {
                                                            ls[j] = Long.parseLong(e1[j]);
                                                        } catch (Exception var15) {
                                                            var15.printStackTrace();
                                                        }
                                                    }
                                                }
                                            }

                                            f.set(clz, ls);
                                            notifyListener(listener, ls);
                                        }
                                    }
                                } catch (Throwable var17) {
                                    var17.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }

            try {
                Method var18 = clz.getMethod("update", new Class[]{Properties.class});
                if (var18 != null && (var18.getModifiers() & 8) != 0) {
                    var18.invoke((Object) null, new Object[]{prop});
                }
            } catch (NoSuchMethodException var13) {
                ;
            } catch (Throwable var14) {
                var14.printStackTrace();
            }

        }
    }

    private static void updateFromConfiguration(String iniPath) {
        Properties prop = readConfigurations(iniPath);
        if (prop != null) {
            Class[] configs = (Class[]) null;
            Object i = configMutex;
            synchronized (configMutex) {
                configs = (Class[]) allConfigs.toArray(new Class[allConfigs.size()]);
            }

            for (int var5 = 0; var5 < configs.length; ++var5) {
                updateAConfigClass(prop, configs[var5]);
            }
        }

    }

    private static Properties readConfigurations(String iniPath) {
        File file = null;
        if (iniPath != null) {
            file = new File(iniPath);
        } else if (configurationFile != null) {
            file = new File(configurationFile);
        } else {
            String fis = "/t/piled/";
            String e = System.getProperty("os.name");
            if (e != null && e.toLowerCase().indexOf("window") != -1) {
                fis = "D:/piled/";
            }

            file = new File(fis, "piled.ini");
        }

        if (!file.exists()) {
            return null;
        } else if (file.lastModified() == lastUpdated) {
            return null;
        } else {
            prop = new Properties();
            FileInputStream fis1 = null;

            try {
                fis1 = new FileInputStream(file);
                prop.load(fis1);
                lastUpdated = file.lastModified();
                Properties var5 = prop;
                return var5;
            } catch (FileNotFoundException var15) {
                var15.printStackTrace();
            } catch (IOException var16) {
                var16.printStackTrace();
            } finally {
                if (fis1 != null) {
                    try {
                        fis1.close();
                    } catch (IOException var14) {
                        var14.printStackTrace();
                    }
                }

            }

            prop = null;
            return null;
        }
    }

    public static String getProperty(String key) {
        return prop == null ? null : prop.getProperty(key);
    }

    public static Object setProperty(String key, String value) {
        if (prop == null) {
            return null;
        } else if (value == null) {
            prop.remove(key);
            return null;
        } else {
            return prop.setProperty(key, value);
        }
    }
}
