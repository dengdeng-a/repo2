from django.contrib import admin
from django.contrib.auth.admin import UserAdmin as BaseUserAdmin
from django.contrib.auth.models import User
from .models import UserInfo
from . import models

class UserInfoInline(admin.TabularInline):
    model = UserInfo
    can_delete = False
    verbose_name = '用户表'

class UserAdmin(BaseUserAdmin):
    inlines = (UserInfoInline,)


class PermissionAdmin(admin.ModelAdmin):
    list_display = ['title','url']
    list_editable = ['url']


admin.site.register(models.Permission,PermissionAdmin)
admin.site.unregister(User)
admin.site.register(User,UserAdmin)
admin.site.register(models.Role)
