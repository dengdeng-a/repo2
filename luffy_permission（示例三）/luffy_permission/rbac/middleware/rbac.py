from django.utils.deprecation import MiddlewareMixin
from django.conf import settings
from django.shortcuts import render, redirect,HttpResponse
import re


class RbacMiddleWare(MiddlewareMixin):
    """
    权限控制的中间件
    """

    def process_request(self,request):
        """
        权限控制
        :param request:
        :return:
        """

        #1.获取当前请求的url
        current_url = request.path_info

        # 白名单处理
        for reg in settings.VALID_URL:
            if re.match(reg,current_url):
                return None

        #2. 获取当前用户session中的所有权限
        permission_list = request.session.get(settings.PERMISSION_SESSION_KEY)
        if not permission_list:
            return redirect('/login/')

        #3. 进行权限校验
        flag = False
        print(current_url)
        print (permission_list)
        for item in permission_list:
           reg = "^%s$" % item.get('permissions__url')
           if re.match(reg,current_url):
               flag=True
               break
        if not flag:
            return HttpResponse('无权访问')


