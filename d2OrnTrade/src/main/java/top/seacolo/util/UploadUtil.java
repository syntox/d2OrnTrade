package top.seacolo.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtil {
    static String imgPath ="D:/picture/d2Trade_pic_store/";    //本地图片存储目录
    static String hero_imgPath ="D:/picture/d2Trade_pic_hero/";    //英雄图片存储目录
    static String imgFileName = null;    //需要上传的文件名
    static File targetFile = null;    //用来存储目标文件

    /**
     * 图片上传
     * @param file
     * @return
     */
    public static String imgFileUpload(MultipartFile file){
        imgFileName = file.getOriginalFilename();
        targetFile = new File(imgPath, imgFileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/imgUpload/"+imgFileName;
    }

    /**
     * 英雄图片上传
     * @param file
     * @return
     */
    public static String heroImgFileUpload(MultipartFile file){
        imgFileName = file.getOriginalFilename();
        targetFile = new File(hero_imgPath, imgFileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/heroImgUpload/"+imgFileName;
    }

}
