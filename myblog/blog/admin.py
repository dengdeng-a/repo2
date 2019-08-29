from django.contrib import admin
from django.contrib.auth.admin import UserAdmin as BaseUserAdmin
from django.contrib.auth.models import User
from .models import *

class viponeInline(admin.TabularInline):
    model = vipone
    can_delete = False
    verbose_name_plural = '普通会员表'

class UserAdmin(BaseUserAdmin):
    inlines = (viponeInline,)

admin.site.unregister(User)
admin.site.register(User, UserAdmin)


#后台显示表的结构
class ArticleAdmin(admin.ModelAdmin):
    list_display = ('title', 'content','pub_time')
    list_filter = ('pub_time',)



admin.site.register(Article,ArticleAdmin)
