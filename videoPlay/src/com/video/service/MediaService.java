package com.video.service;


public interface MediaService {
 
 /**
  * ��Ƶת��
  * @param srcFilePath  ����ָ��Ҫת����ʽ���ļ�,Ҫ��ͼ����ƵԴ�ļ�
  * @param codcFilePath ��ʽת����ĵ��ļ�����·��
  * @param mediaPicPath ��ͼ����·��
  * @return
  */
 public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath);
}
