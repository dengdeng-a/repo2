package com.ServiceNode.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ServiceNode.Service.TypeService;
import com.ServiceNode.bean.Msg;
import com.ServiceNode.bean.Type;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class TypeController {

	@Autowired
	private TypeService typeService;
	
	
	/*
	 * ͨ��tid��ѯ������Ƶ�ļ� ��Ϣ
	 */
	@RequestMapping(value="/oneToManyContext",method=RequestMethod.GET)
	@ResponseBody
	public Msg getInfoByTid(@RequestParam(value="pn",defaultValue="1")Integer pn,Integer tid){
		System.out.println(tid);
		//�ⲻ��һ����ҳ��ѯ
		//����PageHelper��ҳ���
		PageHelper.startPage(pn,3);
		//startPage��������Ĳ�ѯ����һ����ҳ��ѯ
		List<Type> list = typeService.getInfoByTid(tid);
		//��PageInfo�Խ�����а�װ,,,ֻ��Ҫ��pageinfo����ҳ��Ϳ�����
		//pageinfo��װ����ϸ�ķ�ҳ��Ϣ���������ǲ�����������  ,,������ʾ��ҳ��
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * ��ѯ����������Ϣ
	 */
	@RequestMapping(value="/tnameInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg getTypeName(){
		List<Type> type =typeService.getTypeName();
		System.out.println("////////////////////////////");
		System.out.println(type);
		for(int i = 0 ; i < type.size() ; i++) {
			  System.out.println(type.get(i).getTname());
			}
		return Msg.success().add("type", type);
	}
	
	/*
	 * ��ѯ������Ϣ���ļ���Ϣ
	 */
	@RequestMapping(value="/typeAndContentInfo",method=RequestMethod.GET)
	@ResponseBody
	public Msg getTypeAndContentInfo(){
		List<Type> type =typeService.getTypeAndContentAll();
		System.out.println("////////////////////////////");
		System.out.println(type);
		for(int i = 0 ; i < type.size() ; i++) {
			  System.out.println(type.get(i).getTname());
			  System.out.println(type.get(i).getCtext());
			}
		return Msg.success().add("type", type);
	}
}
