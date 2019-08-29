from django.shortcuts import render, redirect,HttpResponse
from rbac import models
from rbac.models import UserInfo
from django.conf import settings
from rbac.service.init_permission import init_permission


from django.contrib.auth import authenticate, login, logout

def denglu(request):
    """
    用户登录
    :param request:
    :return:
    """

    if request.method == 'POST':
        user = authenticate(request, username=request.POST['user'], password=request.POST['pwd'])
        if user is None:
            return render(request,'login.html',{'msg':'用户名或密码错误'})
        else:
            login(request, user)
            request.session['user_info'] = {'id': user.id, 'name': user.username}
            init_permission(request, user)
            return redirect('/customer/list/')
    return render(request, 'login.html')


