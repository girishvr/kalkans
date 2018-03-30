from django.db import models
from pygments.lexers import get_all_lexers
from pygments.styles import get_all_styles
from pygments.lexers import get_lexer_by_name
from pygments.formatters.html import HtmlFormatter
from pygments import highlight




class department(models.Model):
    created = models.DateTimeField(auto_now_add=True)
    
    dept_id = models.AutoField(primary_key=True)
    dept_name = models.CharField(unique=False, max_length=40)
    location = models.CharField(unique=False,max_length=40,default=False)
    team_id = models.CharField(unique=False,max_length=40)
    uname = models.CharField(unique=True,max_length=40,default=False)
    dept_pwd = models.CharField(unique=False,max_length=40,default=False)
    

    class Meta:
        ordering = ('created',)

