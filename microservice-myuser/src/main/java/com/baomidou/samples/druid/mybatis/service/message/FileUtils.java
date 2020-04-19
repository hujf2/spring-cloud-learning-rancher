package com.baomidou.samples.druid.mybatis.service.message;

import com.baomidou.samples.druid.mybatis.utils.ConstantVar;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author junfeng.hu
 * @create 2020-04-11 15:05
 */
public class FileUtils {
    public static void createFile(List<String> fileContext) throws IOException {
        OutputStream os = new FileOutputStream(ConstantVar.localPath);
        IOUtils.writeLines(fileContext,IOUtils.LINE_SEPARATOR, os, "utf-8");
        return ;
    }
}
