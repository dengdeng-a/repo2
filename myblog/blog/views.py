from django.shortcuts import render, redirect
from django.http import HttpResponse
from .import models
from django.contrib.auth.decorators import login_required

#登录
from django.contrib.auth import authenticate, login, logout
#注册 UserCreationForm     修改信息UserChangeForm     修改密码PasswordChangeForm
from django.contrib.auth.forms import UserCreationForm,UserChangeForm, PasswordChangeForm
from .forms import zidingyiForm,zidingyiEditForm
from .models import vipone

#个人中心
@login_required(login_url='blog:denglu')
def user_center(request):
    yonghuInfo = {'yonghuInfo': request.user}
    return render(request,'users/user_center.html',yonghuInfo)

#编辑个人信息
@login_required(login_url='blog:denglu')
def edit_profile(request):
    if request.method == 'POST':
        editForm = zidingyiEditForm(request.POST,instance=request.user,)  # 实例化创建一个表单
        if editForm.is_valid():
            editForm.save()
            request.user.vipone.nicheng = editForm.cleaned_data['nicheng']
            request.user.vipone.birthday = editForm.cleaned_data['birthday']
            request.user.vipone.save()
            # vipone(comvip=user, nicheng=regForm.cleaned_data['nicheng'],
            #        birthday=regForm.cleaned_data['birthday']).save()
            return redirect('blog:user_center')
    else:
        editForm = zidingyiEditForm(instance = request.user)  # 实例化创建一个表单
    return render(request, 'users/edit_profile.html', {'editForm': editForm,'user':request.user})


#修改密码
@login_required(login_url='blog:denglu')
def change_password(request):
    if request.method == 'POST':
        editPassword = PasswordChangeForm(data = request.POST,user=request.user, )  # 实例化创建一个表单
        if editPassword.is_valid():
            editPassword.save()
            return redirect('blog:denglu')
    else:
        editPassword = PasswordChangeForm(user=request.user)  # 实例化创建一个表单
    return render(request, 'users/change_password.html', {'editPassword': editPassword, 'user': request.user})


#注册
def zhuce(request):
    if request.method == 'POST':
        regForm = zidingyiForm(request.POST)
        if regForm.is_valid():
            regForm.save()
            user = authenticate(username=regForm.cleaned_data['username'], password=regForm.cleaned_data['password1'])
            user.email = regForm.cleaned_data['email']
            vipone(comvip=user,nicheng=regForm.cleaned_data['nicheng'],birthday = regForm.cleaned_data['birthday']).save()
            login(request, user)
            return redirect('blog:index')
    else:
        regForm = zidingyiForm()   #实例化创建一个表单
    return render(request,'users/register.html', {'reg':regForm})


#登录
def denglu(request):
    if request.method == 'POST':
       user = authenticate(request,username=request.POST['用户名'],password=request.POST['密码'])
       if user is None:
            return render(request,'users/login.html',{'错误':'用户名不存在'})
       else:
           login(request,user)
           return redirect('blog:index')

    else:
        return render(request,'users/login.html')

#登出
def dengchu(request):
    logout(request)
    return redirect('blog:index')

def index(request):
    articles = models.Article.objects.all()
    return render(request, 'blog/index.html', {'articles': articles})

def article_page(request, article_id):
    article = models.Article.objects.get(pk=article_id)
    return render(request, 'blog/article_page.html', {'article': article})

def edit_page(request, article_id):
    if str(article_id) == '0':
        return render(request, 'blog/edit_page.html')
    article = models.Article.objects.get(pk=article_id)
    return render(request, 'blog/edit_page.html', {'article': article})


def edit_action(request):
    title = request.POST.get('title', 'TITLE')
    content = request.POST.get('content', 'CONTENT')
    article_id = request.POST.get('article_id',0)
    if article_id == '0':
        models.Article.objects.create(title=title,content=content)
        articles = models.Article.objects.all()
        return render(request, 'blog/index.html', {'articles': articles})

    article = models.Article.objects.get(pk=article_id)
    article.title=title
    article.content=content
    article.save()
    return render(request, 'blog/article_page.html', {'article':article})


def uploadImg(request):#图片上传函数
    if request.method == 'POST':
        img = models.Img(img_url=request.FILES.get('img'))
        img.save()
    return render(request,'blog/imgUpload.html')

def showImg(request):#图片显示函数
    imgs = models.Img.objects.all()  # 从数据库中取出所有的图片路径
    context = {
        'imgs': imgs
    }
    return render(request, 'blog/showImg.html', context)

