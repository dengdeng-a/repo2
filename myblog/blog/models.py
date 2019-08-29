from __future__ import unicode_literals
from django.contrib.auth.models import User
from django.db import models

class vipone (models.Model):
    comvip = models.OneToOneField(User, on_delete = models.CASCADE)
    nicheng = models.CharField(blank = True, max_length=50)
    birthday = models.DateField(blank = True)

    class Meta:
        verbose_name_plural = 'vipone'


class Article(models.Model):
    title = models.CharField(max_length=32, default='Title')
    content = models.TextField(null=True)
    pub_time = models.DateTimeField(null=True)

    def __unicode__(self):
        return self . title

class Img(models.Model):
    img_url = models.ImageField(upload_to = 'img')


