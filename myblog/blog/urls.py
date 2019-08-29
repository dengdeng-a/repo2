from django.conf.urls import url
from django.contrib import admin
from blog import views
from django.conf.urls.static import static
from django.conf import settings

app_name = 'blog'
urlpatterns = [
    url(r'^index/$', views.index, name = 'index'),
    url(r'^article/(?P<article_id>[0-9]+)$', views.article_page, name='article_page'),
    url(r'^edit/(?P<article_id>[0-9]+)$', views.edit_page, name='edit_page'),
    url(r'^edit/action/$', views.edit_action,name='edit_action'),
    url(r'^uploadImg/$', views.uploadImg),
    url(r'^showImg/$', views.showImg, name = 'showImg'),

    #登录
    url(r'^denglu/$',views.denglu,name = 'denglu'),
    #退出
    url(r'^dengchu/$',views.dengchu,name = 'dengchu'),
    #注册
    url(r'^zhuce/$',views.zhuce, name =  'zhuce'),
    #个人中心
    url(r'^user_center/$',views.user_center, name = 'user_center'),
    #编辑个人信息
    url(r'^user_center/edit_profile/$',views.edit_profile, name = 'edit_profile'),
    #修改密码
    url(r'^user_center/change_password/$',views.change_password, name = 'change_password'),

]+ static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
