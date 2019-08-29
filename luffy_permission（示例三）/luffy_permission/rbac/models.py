from __future__ import unicode_literals
from django.contrib.auth.models import User
from django.db import models

class Menu(models.Model):
    """
    菜单表
    """
    title = models.CharField(max_length=32)
    icon = models.CharField(max_length = 32)


class Permission(models.Model):
    """
    权限表s
    """
    title = models.CharField(verbose_name='标题', max_length=32)
    url = models.CharField(verbose_name='含正则的URL', max_length=128)

    meun = models.ForeignKey(verbose_name = '菜单', to = Menu,null = True,blank = True)

    def __str__(self):
        return self.title


class Role(models.Model):
    """
    角色
    """
    title = models.CharField(verbose_name='角色名称', max_length=32)
    permissions = models.ManyToManyField(verbose_name='拥有的所有权限', to='Permission', blank=True)

    def __str__(self):
        return self.title


class UserInfo(models.Model):
    """
    用户表
    """

    user = models.OneToOneField(User,on_delete=models.CASCADE)
    roles = models.ManyToManyField(verbose_name='拥有的所有角色', to='Role', blank=True)
    nicheng = models.CharField(blank = True,max_length = 50)

    # def __str__(self):
    #     return self.name

    class Meta:
        verbose_name_plural = 'UserInfo'
