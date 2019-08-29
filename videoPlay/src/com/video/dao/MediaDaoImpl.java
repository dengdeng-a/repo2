package com.video.dao;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
 
public class MediaDaoImpl implements MediaDao {
 
  public boolean isConvertFLV(String file) {
    boolean result = false;
    String ext = file.substring(file.lastIndexOf(".") + 1,   
      		  file.length()).toLowerCase();
    // ffmpeg�ܽ����ĸ�ʽ����asx��asf��mpg��wmv��3gp��mp4��mov��avi��flv�ȣ� 
    if (ext.equals("avi")) {  
      result = true;  
    } else if (ext.equals("mpg")) {  
      result = true;  
    } else if (ext.equals("wmv")) {  
      result = true;  
    } else if (ext.equals("3gp")) {  
      result = true;  
  } else if (ext.equals("mov")) {  
    result = true;  
  } else if (ext.equals("mp4")) {  
    result = true;  
  } else if (ext.equals("asf")) {  
    result = true;  
  } else if (ext.equals("asx")) {  
    result = true;   
  } else if (ext.equals("flv")) {  
    result = true;    
  }  
    return result;
  }
 
  public boolean isConvertAVI(String file) {
    boolean result = false;
    String ext = file.substring(file.lastIndexOf(".") + 1,   
      		  file.length()).toLowerCase();
    // ��ffmpeg�޷��������ļ���ʽ(wmv9��rm��rmvb��),  
  // �������ñ�Ĺ��ߣ�mencoder��ת��Ϊavi(ffmpeg�ܽ�����)��ʽ.  
  if (ext.equals("wmv9")) {  
    result = true;  
  } else if (ext.equals("rm")) {  
    result = true; 
  } else if (ext.equals("rmvb")) {  
    result = true; 
  }  
    return result;
  }
 
  public boolean executeCodecs(String srcFilePath, String codcFilePath,
      String mediaPicPath) {
    String basePath = System.getProperty("user.dir");
    String mencoderPath = "D:\\bbsp\\work\\MediaPlayer\\src\\main\\resources\\tools\\mencoder.exe";
    String ffmpegPath = "D:\\bbsp\\work\\MediaPlayer\\src\\main\\resources\\tools\\ffmpeg.exe";
    boolean mark = true;
    String tempPath = basePath + File.separator + "temp" + File.separator + String.valueOf(System.currentTimeMillis())+ ".avi";
    if(isConvertAVI(srcFilePath)){
      mark = this.convertAVI(mencoderPath, srcFilePath, tempPath);
      srcFilePath = tempPath;
    }
    if(isConvertFLV(srcFilePath) && mark){
      mark = this.convertFLV(ffmpegPath, srcFilePath, codcFilePath);
      mark = this.cutPic(ffmpegPath, srcFilePath, mediaPicPath);
    }else{
      System.out.println("����Ƶ��ʽ�޷�ת��");
      mark = false;
    }
    this.deleteAVIFile(tempPath);
    return mark;
  }
  
  private boolean convertFLV(String ffmpegPath,String srcFilePath, String codcFilePath) {
    File file = new File(ffmpegPath);
    File srcFile = new File(srcFilePath);
    if(file.exists()){
      System.out.println("ת�����ߴ���");
    }
    if(srcFile.exists()){
      System.out.println("Դ��Ƶ����");
    }
    // ����һ��List����������ת����Ƶ�ļ�Ϊflv��ʽ������
  List<String> convert = new ArrayList<String>();
  convert.add(ffmpegPath); // ���ת������·��
  convert.add("-i"); // ��Ӳ�����-i�����ò���ָ��Ҫת�����ļ�
  convert.add(srcFilePath); // ���Ҫת����ʽ����Ƶ�ļ���·��
  convert.add("-ab");	//������Ƶ����
  convert.add("128");
  convert.add("-ac");	//����������
  convert.add("2");
  convert.add("-qscale");       
  convert.add("6");
  convert.add("-ar");	//���������Ĳ���Ƶ��
  convert.add("22050");
  convert.add("-r");	//����֡Ƶ
  convert.add("29.97");
  convert.add("-b");
  convert.add("5942.13");
  convert.add("-s");
  convert.add("1280x720");
  convert.add("-y"); // ��Ӳ�����-y�����ò���ָ���������Ѵ��ڵ��ļ�
  convert.add(codcFilePath);
 
  boolean mark = true;
  try {
      Process proc = new ProcessBuilder(convert).redirectErrorStream(true).start();
      BufferedReader stdout = new BufferedReader(  
        new InputStreamReader(proc.getInputStream()));  
      String line;  
      while ((line = stdout.readLine()) != null) {  
      	System.out.println(line);
      }   
  } catch (Exception e) {
      mark = false;
      System.out.println(e);
      e.printStackTrace();
  }
  return mark;
  }
  
  private Boolean cutPic(String ffmpegPath, String srcFilePath, String mediaPicPath) {
    // ����һ��List�������������Ƶ�н�ȡͼƬ������
  List<String> cutpic = new ArrayList<String>();
  cutpic.add(ffmpegPath);
  cutpic.add("-i");
  cutpic.add(srcFilePath); // ͬ�ϣ�ָ�����ļ���������ת��Ϊflv��ʽ֮ǰ���ļ���Ҳ������ת����flv�ļ���
  cutpic.add("-y");
  cutpic.add("-f");
  cutpic.add("image2");
  cutpic.add("-ss"); // ��Ӳ�����-ss�����ò���ָ����ȡ����ʼʱ��
  cutpic.add("7"); // �����ʼʱ��Ϊ��17��
  cutpic.add("-t"); // ��Ӳ�����-t�����ò���ָ������ʱ��
  cutpic.add("0.001"); // ��ӳ���ʱ��Ϊ1����
  cutpic.add("-s"); // ��Ӳ�����-s�����ò���ָ����ȡ��ͼƬ��С
  cutpic.add("800*280"); // ��ӽ�ȡ��ͼƬ��СΪ350*240
  cutpic.add(mediaPicPath); // ��ӽ�ȡ��ͼƬ�ı���·��
 
  boolean mark = true;
  ProcessBuilder builder = new ProcessBuilder();
  try {
      builder.command(cutpic);
      builder.redirectErrorStream(true);
      // ���������Ϊ true�����κ���ͨ���˶���� start() ���������ĺ����ӽ������ɵĴ�������������׼����ϲ���
      //������߾���ʹ�� Process.getInputStream() ������ȡ����ʹ�ù���������Ϣ����Ӧ�������ø�����
      builder.start();
  } catch (Exception e) {
      mark = false;
      System.out.println(e);
      e.printStackTrace();
  }
  return mark;
  }
  
  private boolean convertAVI(String mencoderPath,String srcFilePath, String codcFilePath) {  
  List<String> commend = new ArrayList<String>();  
  commend.add(mencoderPath);  
  commend.add(srcFilePath);  
  commend.add("-oac");  
  commend.add("lavc");  
  commend.add("-lavcopts");  
  commend.add("acodec=mp3:abitrate=64");  
  commend.add("-ovc");  
  commend.add("xvid");  
  commend.add("-xvidencopts");  
  commend.add("bitrate=600");  
  commend.add("-of");  
  commend.add("avi");  
  commend.add("-o");  
  commend.add(codcFilePath);  
  try {  
      ProcessBuilder builder = new ProcessBuilder();  
      builder.command(commend);  
      builder.redirectErrorStream(true);//�����ӽ��̴���������׼����ϲ�
      Process p = builder.start();  
      p.getInputStream();
      //�������̵ȴ�Mencoder����ת��������ſɽ���
      p.waitFor(); 
      return true;
  } catch (Exception e) {  
      e.printStackTrace();  
      return false;  
  }  
    }
 
  public void deleteAVIFile(String tempFile) {
    File file = new File(tempFile);
    if(file.exists()){
      file.delete();
    }
  }  
 
}

