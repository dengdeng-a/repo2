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
	 * 通过tid查询分类视频文件 信息
	 */
	@RequestMapping(value="/oneToManyContext",method=RequestMethod.GET)
	@ResponseBody
	public Msg getInfoByTid(@RequestParam(value="pn",defaultValue="1")Integer pn,Integer tid){
		System.out.println(tid);
		//这不是一个分页查询
		//引入PageHelper分页插件
		PageHelper.startPage(pn,3);
		//startPage后面紧跟的查询就是一个分页查询
		List<Type> list = typeService.getInfoByTid(tid);
		//用PageInfo对结果进行包装,,,只需要将pageinfo交给页面就可以了
		//pageinfo封装了详细的分页信息，包括我们擦出来的数据  ,,连续显示的页数
		PageInfo page = new PageInfo(list,5);
		return Msg.success().add("pageInfo", page);
	}
	
	/*
	 * 查询分类名字信息
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
	 * 查询分类信息和文件信息
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
