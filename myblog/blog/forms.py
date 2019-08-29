from django.contrib.auth.forms import UserCreationForm, UserChangeForm
from django import forms
from django.contrib.auth.models import User
#验证码
from captcha.fields import CaptchaField


# 自定义编辑表单，继承原来的表单UserChangeForm
class zidingyiEditForm(UserChangeForm):
    nicheng = forms.CharField(required=False, max_length=50)
    birthday = forms.CharField(required=False)

    class Meta:
        model = User
		#显示什么是可以被编辑的
        fields = ('username', 'password', 'email', 'nicheng', 'birthday')

    # 初始化的构造函数
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['username'].error_messages = {'unique': '用户名已存在！！！！ ', 'invalid': '格式不正确！！！'}


# 自定义注册表单，继承原来的表单
class zidingyiForm(UserCreationForm):
    nicheng = forms.CharField(required=False, max_length=50)
    birthday = forms.CharField(required=False)
    captcha = CaptchaField()
    class Meta:
        model = User
        fields = ('username', 'password1', 'password2', 'email', 'nicheng', 'birthday')

    # 初始化的构造函数
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['username'].error_messages = {'unique': '用户名已存在！！！！ '}
