package com.video.test;

import com.video.dao.MediaDao;
import com.video.dao.MediaDaoImpl;
import com.video.service.MediaServiceImpl;

public class TestMediaPlayer {

  public static void main(String[] args) {
    //�Զ��巽ʽ�����ļ���
  String serialName = String.valueOf(System.currentTimeMillis());
    String srcFilePath ="D:\\bbsp\\work\\MediaPlayer\\src\\main\\resources\\videos\\Wildlife.wmv";
    String codcFilePath = "D:\\bbsp\\work\\MediaPlayer\\src\\main\\resources\\videos\\" + serialName + ".flv";
    String mediaPicPath = "D:\\bbsp\\work\\MediaPlayer\\src\\main\\resources\\images\\" + serialName + ".jpg";
    MediaDao mediaDao = new MediaDaoImpl();
    MediaServiceImpl mediaService = new MediaServiceImpl();
    mediaService.setMediaDao(mediaDao);
    mediaService.executeCodecs(srcFilePath, codcFilePath, mediaPicPath);
  }
 

}
