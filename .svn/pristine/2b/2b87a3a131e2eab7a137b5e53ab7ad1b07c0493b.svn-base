//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.tt.javaserver.web.conf.gen;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.*;

public class ConfigINIGenerator {
    private static Charset UTF_8 = Charset.forName("utf-8");

    public ConfigINIGenerator() {
    }

    private static String readFile(File file) {
        FileInputStream fis = null;
        byte[] buffer = new byte[8096];
        boolean read = true;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            fis = new FileInputStream(file);

            int read1;
            while ((read1 = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, read1);
            }
        } catch (IOException var14) {
            ;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException var13) {
                    ;
                }
            }

        }

        return new String(baos.toByteArray(), UTF_8);
    }

    private static String replaceStrForINI(String str) {
        return str.replaceAll("\\\\", "\\\\").replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n").replaceAll("\t", "\\\\t");
    }

    public static void main(String[] args) {
        if (args != null && args.length >= 2) {
            boolean mode = false;
            String targetFile = args[0];
            String mergingFile = null;
            ArrayList allNames = new ArrayList();

            for (int classes = 1; classes < args.length; ++classes) {
                String clazz = args[classes];
                if (clazz != null && clazz.length() > 0) {
                    if (clazz.endsWith(".ini")) {
                        mode = true;
                        mergingFile = clazz;
                    } else {
                        try {
                            Class e = Class.forName(clazz);
                            allNames.add(e);
                        } catch (ClassNotFoundException var8) {
                            var8.printStackTrace();
                        }
                    }
                }
            }

            Class[] var9 = (Class[]) allNames.toArray(new Class[allNames.size()]);
            if (!mode) {
                generateDefaultINI(targetFile, var9, (IConfigurable) null);
            } else {
                generateDeltaINI(targetFile, mergingFile, var9, (IConfigurable) null);
            }

        } else {
            System.out.println("Usage: " + ConfigINIGenerator.class.getName() + " <target ini file> <config class> [config class ...]");
        }
    }

    public static void generateDefaultINI(String file, Class<?>[] classes, IConfigurable checking) {
        ArrayList allConfigs = new ArrayList();

        for (int allFields = 0; allFields < classes.length; ++allFields) {
            Class skipUnchangedLines = classes[allFields];
            if (checking == null || checking.isConfigClass(skipUnchangedLines)) {
                allConfigs.add(skipUnchangedLines);
            }
        }

        HashMap var28 = new HashMap();
        boolean var29 = false;
        StringBuilder builder = new StringBuilder();
        Iterator source = allConfigs.iterator();

        while (source.hasNext()) {
            Class oldSource = (Class) source.next();
            Field[] fos = oldSource.getFields();
            builder.append("\r\n");
            builder.append("# ");
            builder.append(oldSource.getSimpleName());
            builder.append("\r\n");

            for (int e = 0; e < fos.length; ++e) {
                Field f = fos[e];
                if (f != null) {
                    int e1 = f.getModifiers();
                    if ((e1 & 5) != 0 && (e1 & 8) != 0 && (e1 & 16) == 0) {
                        String name = f.getName();
                        if (var28.containsKey(name)) {
                            System.out.println(oldSource.getSimpleName() + "." + name + " is duplicated with " + (String) var28.get(name));
                        }

                        var28.put(name, oldSource.getSimpleName() + "." + name);
                        Class type = f.getType();

                        try {
                            if (type == Integer.TYPE) {
                                int var42 = f.getInt(oldSource);
                                if (var42 == 0) {
                                    if (var29) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(name);
                                builder.append("=");
                                builder.append(var42);
                                builder.append("\r\n");
                            } else if (type == String.class) {
                                String var43 = (String) f.get(oldSource);
                                if (var43 == null) {
                                    if (var29) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(name);
                                builder.append("=");
                                if (var43 != null) {
                                    builder.append(replaceStrForINI(var43));
                                }

                                builder.append("\r\n");
                            } else if (type == Boolean.TYPE) {
                                boolean var38 = f.getBoolean(oldSource);
                                if (!var38) {
                                    if (var29) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(name);
                                builder.append("=");
                                builder.append(var38);
                                builder.append("\r\n");
                            } else if (type == Long.TYPE) {
                                long var39 = f.getLong(oldSource);
                                if (var39 == 0L) {
                                    if (var29) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(name);
                                builder.append("=");
                                builder.append(var39);
                                builder.append("\r\n");
                            } else {
                                int k;
                                if (type == String[].class) {
                                    String[] var40 = (String[]) f.get(oldSource);
                                    if (var40 == null) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    if (var40 != null) {
                                        for (k = 0; k < var40.length; ++k) {
                                            if (k > 0) {
                                                builder.append(";");
                                            }

                                            String v = var40[k];
                                            if (v != null) {
                                                builder.append(replaceStrForINI(v));
                                            }
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (type == int[].class) {
                                    int[] var41 = (int[]) f.get(oldSource);
                                    if (var41 == null) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    if (var41 != null) {
                                        for (k = 0; k < var41.length; ++k) {
                                            if (k > 0) {
                                                builder.append(";");
                                            }

                                            builder.append(var41[k]);
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (type == long[].class) {
                                    long[] var34 = (long[]) f.get(oldSource);
                                    if (var34 == null) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    if (var34 != null) {
                                        for (k = 0; k < var34.length; ++k) {
                                            if (k > 0) {
                                                builder.append(";");
                                            }

                                            builder.append(var34[k]);
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (type == Double.TYPE) {
                                    double var35 = f.getDouble(oldSource);
                                    if (var35 == 0.0D) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    builder.append(var35);
                                    builder.append("\r\n");
                                } else if (type == Float.TYPE) {
                                    float var36 = f.getFloat(oldSource);
                                    if (var36 == 0.0F) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    builder.append(var36);
                                    builder.append("\r\n");
                                } else if (type == Short.TYPE) {
                                    short var37 = f.getShort(oldSource);
                                    if (var37 == 0) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    builder.append(var37);
                                    builder.append("\r\n");
                                } else if (type == Byte.TYPE) {
                                    byte var33 = f.getByte(oldSource);
                                    if (var33 == 0) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    builder.append(var33);
                                    builder.append("\r\n");
                                } else if (type == Character.TYPE) {
                                    char e2 = f.getChar(oldSource);
                                    if (e2 == 0) {
                                        if (var29) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(name);
                                    builder.append("=");
                                    builder.append(e2);
                                    builder.append("\r\n");
                                }
                            }
                        } catch (Throwable var27) {
                            var27.printStackTrace();
                        }
                    }
                }
            }
        }

        String var30 = builder.toString();
        String var31 = readFile(new File(file));
        if (!var30.equals(var31)) {
            System.out.println((var31 != null && var31.length() != 0 ? "Update " : "Write ") + file);
            FileOutputStream var32 = null;

            try {
                var32 = new FileOutputStream(file);
                var32.write(var30.getBytes(UTF_8));
            } catch (IOException var25) {
                var25.printStackTrace();
            } finally {
                if (var32 != null) {
                    try {
                        var32.close();
                    } catch (IOException var24) {
                        var24.printStackTrace();
                    }
                }

            }
        }

    }

    public static void generateDeltaINI(String targetFile, String mergingFile, Class<?>[] classes, IConfigurable checking) {
        ArrayList allConfigs = new ArrayList();

        for (int allFields = 0; allFields < classes.length; ++allFields) {
            Class skipUnchangedLines = classes[allFields];
            if (checking == null || checking.isConfigClass(skipUnchangedLines)) {
                allConfigs.add(skipUnchangedLines);
            }
        }

        HashMap var38 = new HashMap();
        boolean var39 = false;
        StringBuilder builder = new StringBuilder();
        Iterator source = allConfigs.iterator();

        int var67;
        while (source.hasNext()) {
            Class props = (Class) source.next();
            Field[] bais = props.getFields();
            builder.append("\r\n");
            builder.append("# ");
            builder.append(props.getSimpleName());
            builder.append("\r\n");

            for (int oldSource = 0; oldSource < bais.length; ++oldSource) {
                Field fos = bais[oldSource];
                if (fos != null) {
                    int e = fos.getModifiers();
                    if ((e & 5) != 0 && (e & 8) != 0 && (e & 16) == 0) {
                        String i = fos.getName();
                        if (var38.containsKey(i)) {
                            System.out.println(props.getSimpleName() + "." + i + " is duplicated with " + (String) var38.get(i));
                        }

                        var38.put(i, props.getSimpleName() + "." + i);
                        Class e1 = fos.getType();

                        try {
                            if (e1 == Integer.TYPE) {
                                var67 = fos.getInt(props);
                                if (var67 == 0) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(i);
                                builder.append("=");
                                builder.append(var67);
                                builder.append("\r\n");
                            } else if (e1 == String.class) {
                                String var57 = (String) fos.get(props);
                                if (var57 == null) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(i);
                                builder.append("=");
                                if (var57 != null) {
                                    builder.append(replaceStrForINI(var57));
                                }

                                builder.append("\r\n");
                            } else if (e1 == Boolean.TYPE) {
                                boolean var58 = fos.getBoolean(props);
                                if (!var58) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(i);
                                builder.append("=");
                                builder.append(var58);
                                builder.append("\r\n");
                            } else if (e1 == Long.TYPE) {
                                long var60 = fos.getLong(props);
                                if (var60 == 0L) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(i);
                                builder.append("=");
                                builder.append(var60);
                                builder.append("\r\n");
                            } else {
                                int name;
                                if (e1 == String[].class) {
                                    String[] var62 = (String[]) fos.get(props);
                                    if (var62 == null) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    if (var62 != null) {
                                        for (name = 0; name < var62.length; ++name) {
                                            if (name > 0) {
                                                builder.append(";");
                                            }

                                            String type = var62[name];
                                            if (type != null) {
                                                builder.append(replaceStrForINI(type));
                                            }
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (e1 == int[].class) {
                                    int[] var52 = (int[]) fos.get(props);
                                    if (var52 == null) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    if (var52 != null) {
                                        for (name = 0; name < var52.length; ++name) {
                                            if (name > 0) {
                                                builder.append(";");
                                            }

                                            builder.append(var52[name]);
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (e1 == long[].class) {
                                    long[] var53 = (long[]) fos.get(props);
                                    if (var53 == null) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    if (var53 != null) {
                                        for (name = 0; name < var53.length; ++name) {
                                            if (name > 0) {
                                                builder.append(";");
                                            }

                                            builder.append(var53[name]);
                                        }
                                    }

                                    builder.append("\r\n");
                                } else if (e1 == Double.TYPE) {
                                    double var54 = fos.getDouble(props);
                                    if (var54 == 0.0D) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    builder.append(var54);
                                    builder.append("\r\n");
                                } else if (e1 == Float.TYPE) {
                                    float var55 = fos.getFloat(props);
                                    if (var55 == 0.0F) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    builder.append(var55);
                                    builder.append("\r\n");
                                } else if (e1 == Short.TYPE) {
                                    short var50 = fos.getShort(props);
                                    if (var50 == 0) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    builder.append(var50);
                                    builder.append("\r\n");
                                } else if (e1 == Byte.TYPE) {
                                    byte var51 = fos.getByte(props);
                                    if (var51 == 0) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    builder.append(var51);
                                    builder.append("\r\n");
                                } else if (e1 == Character.TYPE) {
                                    char modifiers = fos.getChar(props);
                                    if (modifiers == 0) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(i);
                                    builder.append("=");
                                    builder.append(modifiers);
                                    builder.append("\r\n");
                                }
                            }
                        } catch (Throwable var37) {
                            var37.printStackTrace();
                        }
                    }
                }
            }
        }

        String var40 = builder.toString();
        Properties var41 = new Properties();
        ByteArrayInputStream var42 = new ByteArrayInputStream(var40.getBytes(UTF_8));

        try {
            var41.load(var42);
        } catch (IOException var34) {
            var34.printStackTrace();
        }

        Config.initialize(mergingFile);
        Iterator var45 = allConfigs.iterator();

        Class var44;
        while (var45.hasNext()) {
            var44 = (Class) var45.next();
            Config.registerUpdatingListener(var44);
        }

        if (checking != null) {
            checking.updateConfigs();
        }

        builder = new StringBuilder();
        var45 = allConfigs.iterator();

        while (var45.hasNext()) {
            var44 = (Class) var45.next();
            Field[] var47 = var44.getFields();
            builder.append("\r\n");
            builder.append("# ");
            builder.append(var44.getSimpleName());
            builder.append("\r\n");

            for (int var49 = 0; var49 < var47.length; ++var49) {
                Field var48 = var47[var49];
                if (var48 != null) {
                    var67 = var48.getModifiers();
                    if ((var67 & 5) != 0 && (var67 & 8) != 0 && (var67 & 16) == 0) {
                        String var59 = var48.getName();
                        Class var61 = var48.getType();

                        try {
                            String v0;
                            if (var61 == Integer.TYPE) {
                                int var69 = var48.getInt(var44);
                                v0 = var41.getProperty(var59);
                                if (v0 != null && v0.equals(String.valueOf(var69)) || v0 == null && var69 == 0) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(var59);
                                builder.append("=");
                                builder.append(var69);
                                builder.append("\r\n");
                            } else if (var61 == String.class) {
                                String var68 = (String) var48.get(var44);
                                v0 = var41.getProperty(var59);
                                if (v0 != null && v0.equals(var68) || v0 == null && var68 == null) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(var59);
                                builder.append("=");
                                if (var68 != null) {
                                    builder.append(replaceStrForINI(var68));
                                }

                                builder.append("\r\n");
                            } else if (var61 == Boolean.TYPE) {
                                boolean var74 = var48.getBoolean(var44);
                                v0 = var41.getProperty(var59);
                                if (v0 != null && v0.equals(String.valueOf(var74)) || v0 == null && !var74) {
                                    if (var39) {
                                        continue;
                                    }

                                    builder.append("#");
                                }

                                builder.append(var59);
                                builder.append("=");
                                builder.append(var74);
                                builder.append("\r\n");
                            } else {
                                String v01;
                                if (var61 == Long.TYPE) {
                                    long var73 = var48.getLong(var44);
                                    v01 = var41.getProperty(var59);
                                    if (v01 != null && v01.equals(String.valueOf(var73)) || v01 == null && var73 == 0L) {
                                        if (var39) {
                                            continue;
                                        }

                                        builder.append("#");
                                    }

                                    builder.append(var59);
                                    builder.append("=");
                                    builder.append(var73);
                                    builder.append("\r\n");
                                } else {
                                    int k;
                                    StringBuilder var71;
                                    if (var61 == String[].class) {
                                        String[] var72 = (String[]) var48.get(var44);
                                        v0 = var41.getProperty(var59);
                                        var71 = new StringBuilder();
                                        String v;
                                        if (var72 != null) {
                                            for (k = 0; k < var72.length; ++k) {
                                                if (k > 0) {
                                                    var71.append(";");
                                                }

                                                v = var72[k];
                                                if (v != null) {
                                                    var71.append(replaceStrForINI(v));
                                                }
                                            }
                                        }

                                        if (v0 != null && v0.equals(var71.toString()) || v0 == null && var72 == null) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        if (var72 != null) {
                                            for (k = 0; k < var72.length; ++k) {
                                                if (k > 0) {
                                                    builder.append(";");
                                                }

                                                v = var72[k];
                                                if (v != null) {
                                                    builder.append(v);
                                                }
                                            }
                                        }

                                        builder.append("\r\n");
                                    } else if (var61 == int[].class) {
                                        int[] var70 = (int[]) var48.get(var44);
                                        v0 = var41.getProperty(var59);
                                        var71 = new StringBuilder();
                                        if (var70 != null) {
                                            for (k = 0; k < var70.length; ++k) {
                                                if (k > 0) {
                                                    var71.append(";");
                                                }

                                                var71.append(var70[k]);
                                            }
                                        }

                                        if (v0 != null && v0.equals(var71.toString()) || v0 == null && var70 == null) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        if (var70 != null) {
                                            for (k = 0; k < var70.length; ++k) {
                                                if (k > 0) {
                                                    builder.append(";");
                                                }

                                                builder.append(var70[k]);
                                            }
                                        }

                                        builder.append("\r\n");
                                    } else if (var61 == long[].class) {
                                        long[] var63 = (long[]) var48.get(var44);
                                        v0 = var41.getProperty(var59);
                                        var71 = new StringBuilder();
                                        if (var63 != null) {
                                            for (k = 0; k < var63.length; ++k) {
                                                if (k > 0) {
                                                    var71.append(";");
                                                }

                                                var71.append(var63[k]);
                                            }
                                        }

                                        if (v0 != null && v0.equals(var71.toString()) || v0 == null && var63 == null) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        if (var63 != null) {
                                            for (k = 0; k < var63.length; ++k) {
                                                if (k > 0) {
                                                    builder.append(";");
                                                }

                                                builder.append(var63[k]);
                                            }
                                        }

                                        builder.append("\r\n");
                                    } else if (var61 == Double.TYPE) {
                                        double var64 = var48.getDouble(var44);
                                        v01 = var41.getProperty(var59);
                                        if (v01 != null && v01.equals(String.valueOf(var64)) || v01 == null && var64 == 0.0D) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        builder.append(var64);
                                        builder.append("\r\n");
                                    } else if (var61 == Float.TYPE) {
                                        float var65 = var48.getFloat(var44);
                                        v0 = var41.getProperty(var59);
                                        if (v0 != null && v0.equals(String.valueOf(var65)) || v0 == null && var65 == 0.0F) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        builder.append(var65);
                                        builder.append("\r\n");
                                    } else if (var61 == Short.TYPE) {
                                        short var66 = var48.getShort(var44);
                                        v0 = var41.getProperty(var59);
                                        if (v0 != null && v0.equals(String.valueOf(var66)) || v0 == null && var66 == 0) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        builder.append(var66);
                                        builder.append("\r\n");
                                    } else if (var61 == Byte.TYPE) {
                                        byte var56 = var48.getByte(var44);
                                        v0 = var41.getProperty(var59);
                                        if (v0 != null && v0.equals(String.valueOf(var56)) || v0 == null && var56 == 0) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        builder.append(var56);
                                        builder.append("\r\n");
                                    } else if (var61 == Character.TYPE) {
                                        char e2 = var48.getChar(var44);
                                        v0 = var41.getProperty(var59);
                                        if (v0 != null && v0.equals(String.valueOf(e2)) || v0 == null && e2 == 0) {
                                            if (var39) {
                                                continue;
                                            }

                                            builder.append("#");
                                        }

                                        builder.append(var59);
                                        builder.append("=");
                                        builder.append(e2);
                                        builder.append("\r\n");
                                    }
                                }
                            }
                        } catch (Throwable var36) {
                            var36.printStackTrace();
                        }
                    }
                }
            }
        }

        var40 = builder.toString();
        String var43 = readFile(new File(targetFile));
        if (!var40.equals(var43)) {
            System.out.println((var43 != null && var43.length() != 0 ? "Update " : "Write ") + targetFile);
            FileOutputStream var46 = null;

            try {
                var46 = new FileOutputStream(targetFile);
                var46.write(var40.getBytes(UTF_8));
            } catch (IOException var33) {
                var33.printStackTrace();
            } finally {
                if (var46 != null) {
                    try {
                        var46.close();
                    } catch (IOException var32) {
                        var32.printStackTrace();
                    }
                }

            }
        }

        Config.switchConfig(targetFile);
        if (checkSavedINIFile(targetFile, allConfigs)) {
            System.out.println("Saved " + targetFile + " is incorrect!");
        } else {
            System.out.println("Done!");
        }

    }

    private static boolean checkSavedINIFile(String file, List<Class<?>> allConfigs) {
        Properties props = new Properties();
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            props.load(fis);
        } catch (IOException var25) {
            var25.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException var24) {
                    var24.printStackTrace();
                }
            }

        }

        boolean changed = false;
        Iterator itr = allConfigs.iterator();

        while (itr.hasNext()) {
            Class clz = (Class) itr.next();
            Field[] fields = clz.getFields();

            for (int i = 0; i < fields.length; ++i) {
                Field f = fields[i];
                if (f != null) {
                    int modifiers = f.getModifiers();
                    if ((modifiers & 5) != 0 && (modifiers & 8) != 0 && (modifiers & 16) == 0) {
                        String name = f.getName();
                        Class type = f.getType();

                        try {
                            String v0;
                            if (type == Integer.TYPE) {
                                int e = f.getInt(clz);
                                v0 = props.getProperty(name);
                                if (v0 != null && !v0.equals(String.valueOf(e))) {
                                    changed = true;
                                    break;
                                }
                            } else if (type == String.class) {
                                String var30 = (String) f.get(clz);
                                v0 = props.getProperty(name);
                                if (v0 != null && !v0.equals(var30)) {
                                    changed = true;
                                    break;
                                }
                            } else if (type == Boolean.TYPE) {
                                boolean var28 = f.getBoolean(clz);
                                v0 = props.getProperty(name);
                                if (v0 != null && !v0.equals(String.valueOf(var28))) {
                                    changed = true;
                                    break;
                                }
                            } else {
                                String v01;
                                if (type == Long.TYPE) {
                                    long var29 = f.getLong(clz);
                                    v01 = props.getProperty(name);
                                    if (v01 != null && !v01.equals(String.valueOf(var29))) {
                                        changed = true;
                                        break;
                                    }
                                } else {
                                    int k;
                                    StringBuilder var32;
                                    if (type == String[].class) {
                                        String[] var34 = (String[]) f.get(clz);
                                        v0 = props.getProperty(name);
                                        var32 = new StringBuilder();
                                        if (var34 != null) {
                                            for (k = 0; k < var34.length; ++k) {
                                                if (k > 0) {
                                                    var32.append(";");
                                                }

                                                String v = var34[k];
                                                if (v != null) {
                                                    var32.append(replaceStrForINI(v));
                                                }
                                            }
                                        }

                                        if (v0 != null && !v0.equals(var32.toString())) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == int[].class) {
                                        int[] var35 = (int[]) f.get(clz);
                                        v0 = props.getProperty(name);
                                        var32 = new StringBuilder();
                                        if (var35 != null) {
                                            for (k = 0; k < var35.length; ++k) {
                                                if (k > 0) {
                                                    var32.append(";");
                                                }

                                                var32.append(var35[k]);
                                            }
                                        }

                                        if (v0 != null && !v0.equals(var32.toString())) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == long[].class) {
                                        long[] var31 = (long[]) f.get(clz);
                                        v0 = props.getProperty(name);
                                        var32 = new StringBuilder();
                                        if (var31 != null) {
                                            for (k = 0; k < var31.length; ++k) {
                                                if (k > 0) {
                                                    var32.append(";");
                                                }

                                                var32.append(var31[k]);
                                            }
                                        }

                                        if (v0 != null && !v0.equals(var32.toString())) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == Double.TYPE) {
                                        double var33 = f.getDouble(clz);
                                        v01 = props.getProperty(name);
                                        if (v01 != null && !v01.equals(String.valueOf(var33))) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == Float.TYPE) {
                                        float var39 = f.getFloat(clz);
                                        v0 = props.getProperty(name);
                                        if (v0 != null && !v0.equals(String.valueOf(var39))) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == Short.TYPE) {
                                        short var38 = f.getShort(clz);
                                        v0 = props.getProperty(name);
                                        if (v0 != null && !v0.equals(String.valueOf(var38))) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == Byte.TYPE) {
                                        byte var37 = f.getByte(clz);
                                        v0 = props.getProperty(name);
                                        if (v0 != null && !v0.equals(String.valueOf(var37))) {
                                            changed = true;
                                            break;
                                        }
                                    } else if (type == Character.TYPE) {
                                        char var36 = f.getChar(clz);
                                        v0 = props.getProperty(name);
                                        if (v0 != null && !v0.equals(String.valueOf(var36))) {
                                            changed = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable var27) {
                            var27.printStackTrace();
                        }
                    }
                }
            }

            if (changed) {
                break;
            }
        }

        return changed;
    }

    public interface IConfigurable {
        boolean isConfigClass(Class<?> var1);

        void updateConfigs();
    }
}
