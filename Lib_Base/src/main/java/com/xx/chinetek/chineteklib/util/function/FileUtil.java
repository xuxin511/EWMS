package com.xx.chinetek.chineteklib.util.function;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * Created by GHOST on 2017/11/6.
 */

public class FileUtil {
    public static Boolean FileExits(String strFilePath) {
        File file = new File(strFilePath);
        if (file.exists())
            return true;
        else
            return false;
    }

    public static Boolean CreateFile(List<String> strFilePaths) {
        Boolean isCreate = true;
        if (strFilePaths != null && strFilePaths.size() != 0) {
            for (String path : strFilePaths) {
                File destDir = new File(path);
                if (!destDir.exists()) {
                    if (!destDir.mkdirs()) {
                        isCreate = false;
                        break;
                    }
                }
            }
        }
        return isCreate;

    }

    /**
     * 判断文件的编码格式
     *
     * @param file
     * @return 文件编码格式
     * @throws Exception
     */
    public static String GetCharSetName(File file) throws Exception{

        BufferedInputStream bin = new BufferedInputStream(
                new FileInputStream(file));
        int p = (bin.read() << 8) + bin.read();
        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }

        return code;
    }

}
