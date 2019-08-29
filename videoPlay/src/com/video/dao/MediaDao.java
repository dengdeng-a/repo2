package com.video.dao;


/**
 * 
 * ����˵������Ƶ����dao
 * @author ljf  email: liangjf@hundsun.com  
 * @date 2014-10-14 ����10:32:31
 * @version 2.0.0
 * @since JDK1.6 
 *
 */
public interface MediaDao {
  
  /**
   * ��Ƶת��
   * @param srcFilePath  ����ָ��Ҫת����ʽ���ļ�,Ҫ��ͼ����ƵԴ�ļ�
   * @param codcFilePath ��ʽת����ĵ��ļ�����·��
   * @param mediaPicPath ��ͼ����·��
   * @return
   */
  public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath);
  
  /**
   * ��ת��ΪFLV��Ƶ�ļ�
   * @param file
   * @return
   */
  public boolean isConvertFLV(String file);
  
  /**
   * ��ת��ΪAVI��Ƶ�ļ�
   * @param file
   * @return
   */
  public boolean isConvertAVI(String file);
  
  /**
   * ɾ���м�ת����Ƶ�ļ�
   * @param tempFile
   */
  public void deleteAVIFile(String tempFile);
  
}

