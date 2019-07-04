package com.imooc.mvcmodeo.controller;

import com.imooc.mvcmodeo.object.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestController {

    //基本数据类型的数据绑定
    //todo http://localhost:8080/baseType.do?age=10
    @RequestMapping(value = "baseType.do",method = RequestMethod.GET)
    @ResponseBody
    public String baseType(@RequestParam("xage") int age){
        return "age:"+age;
    }

    //基本数据类型的封装的数据绑定
    //todo http://localhost:8080/baseType2.do?age=10&&
    @RequestMapping(value = "baseType2.do",method = RequestMethod.GET)
    @ResponseBody
    public String baseType2(Integer age){
        return "age:"+age;
    }

    //数组的数据绑定
    //todo http://localhost:8080/array.do?name=Tom&name=Lucy&name=Jim
    @RequestMapping(value = "array.do")
    @ResponseBody
    public String array(String[] name){
        StringBuilder sbf = new StringBuilder();
        for(String item : name){
            sbf.append(item).append(" ");
        }
        return sbf.toString();
    }

    //todo http://localhost:8080/object.do?name=Tom&&age=10&contactInfo.phone=10086
    @RequestMapping(value = "object.do")
    @ResponseBody
    public String object(User user,Admin admin){
        return user.toString()+" "+admin.toString();
    }

    @InitBinder("user")
    public void initUser(WebDataBinder binder){
        binder.setFieldDefaultPrefix("user.");
    }

    @InitBinder("admin")
    public void initAdmin(WebDataBinder binder){
        binder.setFieldDefaultPrefix("admin.");
    }

    //togo http://localhost:8080/list.do?users[0].name=tom&users[1].name=Lucy
    @RequestMapping(value = "list.do")
    @ResponseBody
    public String list(UserListForm userListForm){
        return userListForm.toString();
    }


    //对set镜像绑定的时候，，要对set进行初始化，，不然绑定的size越界会报500异常
    @RequestMapping(value = "set.do")
    @ResponseBody
    public String set(UserSetForm userSetForm){
        return userSetForm.toString();
    }

    //TODO http://localhost:8080/map.do?users['X'].name=Tom&users['X'].age=10&users['Y'].name=Lucy
    @RequestMapping(value = "map.do")
    @ResponseBody
    public String map(UserMapForm userMapForm){
        return userMapForm.toString();
    }


    //    {
//        "name": "Jim",
//            "age": 16,
//            "contactInfo": {
//                "address": "beijing",
//                "phone": "10010"
//              }
//    }
    //application/json
    @RequestMapping(value = "json.do")
    @ResponseBody
    public String json(@RequestBody User user){
        return user.toString();
    }


    //    <?xml version="1.0" encoding="UTF-8" ?>
//    <admin>
//      <name>Jim</name>
//      <age>16</age>
//    </admin>
    //application/xml
    @RequestMapping(value = "xml.do")
    @ResponseBody
    public String xml(@RequestBody Admin admin){
        return admin.toString();
    }

}
