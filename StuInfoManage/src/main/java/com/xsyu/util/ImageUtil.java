package com.xsyu.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANDOM = new Random();
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);


    public static File transferCommonsMultipartFileToFile(CommonsMultipartFile cFile){
        File newFile = new File(cFile.getOriginalFilename());
        try {
            cFile.transferTo(newFile);
        } catch (IOException e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * 处理缩略图，返回新图片路径
     * @param file
     * @param targetAddr
     * @return
     */
    public static String generateThumbnail(File file, String targetAddr){
        String realFileName = getRandomFileName();
        String extension = getFileExtension(file);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        logger.debug("current relativeAddr is:" + relativeAddr);
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        logger.debug("current complete addr is:"+ PathUtil.getImgBasePath()+ relativeAddr);

        try {
            Thumbnails.of(file).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e){
            logger.error(e.toString());
            e.printStackTrace();
            System.out.println(basePath);
        }

        return relativeAddr;
    }

    /**
     * 创建目标目录所涉及到的目录
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(File thumbnail) {
        String originalFileName = thumbnail.getName();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机的文件名字
     * @return
     */
    private static String getRandomFileName() {
        //获取随机三位数
        //字符串+int ==> 字符串
        int rannum = RANDOM.nextInt(899) + 100;
        String nowTime = SIMPLE_DATE_FORMAT.format(new Date());
        return nowTime+rannum;
    }


//    public static void main(String[] args) throws IOException {
//        Thumbnails.of(new File("image/haimianbaobao.jpg"))
//                .size(200, 200).watermark(Positions.BOTTOM_LEFT,
//                ImageIO.read(new File(basePath + "watermark.jpg")), 0.25f)
//                .outputQuality(0.8f).toFile("image/work/haimianbaobao1.jpg");
//    }
}
