package com.wj.pms.common;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungSmith on 2018/3/8.
 */
public class FileErgodic {

    /**
     * 遍历指定目录及子目录下的文件
     *
     * @author testcs_dn
     * @date    2014年12月12日下午2:33:49
     * @param file 要遍历的指定目录
     * @param collector 符合条件的结果添加到此List<File>中
     * @param pathInclude 路径中包含指定的字符串
     * @param fileNameInclude 文件名（不包含扩展名）中包含指定的字符串
     * @param extnEquals 文件扩展名为指定字符串
     * @param ignoreCatalog 不去遍历的目录
     * @throws IOException
     */
    public static List<File> listFiles(File file, List<File> collector, String pathInclude, String fileNameInclude,
                                 String extnEquals, List<String> ignoreCatalog) throws IOException {
        if (file.isFile()
                && (StringUtils.isEmpty(pathInclude) || file.getAbsolutePath().indexOf(pathInclude) != -1)
                && (StringUtils.isEmpty(fileNameInclude) || file.getName().indexOf(fileNameInclude) != -1)
                && (StringUtils.isEmpty(extnEquals) || file.getName().endsWith(extnEquals))
                ){
            collector.add(file);
        }
        if((!file.isHidden() && file.isDirectory()) && !isIgnoreFile(file, ignoreCatalog)) {
            File[] subFiles = file.listFiles();
            for(int i = 0; i < subFiles.length; i++) {
                listFiles(subFiles[i],collector, pathInclude, fileNameInclude, extnEquals, ignoreCatalog);
            }
        }
        return collector;
    }

    private static boolean isIgnoreFile(File file, List<String> ignoreCatalog) {
        List<String> ignoreList = new ArrayList<String>();
        ignoreList.add(".svn");
        ignoreList.add("CVS");
        ignoreList.add(".cvsignore");
        ignoreList.add("SCCS");
        ignoreList.add("vssver.scc");
        ignoreList.add(".DS_Store");
        for(int i = 0; i < ignoreList.size(); i++) {
            if(file.getName().equals(ignoreList.get(i))) {
                return true;
            }
        }
        return false;
    }
}
