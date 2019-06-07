package com.xsyu.util;

public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "E:/StuInfoManage/image/";
        } else {
            basePath = "/Users/goudan/Desktop/StuInfoManage/image/work/";
        }

        basePath = basePath.replace("/", separator);

        return basePath;
    }

    public static String getStuImgPath(long stuId) {
        String imgPath = "/upload/item/stu/" + stuId + "/";
        return imgPath.replace("/", separator);
    }
}
