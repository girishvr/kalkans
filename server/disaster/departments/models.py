from django.db import models
from pygments.lexers import get_all_lexers
from pygments.styles import get_all_styles

LEXERS = [item for item in get_all_lexers() if item[1]]


class department(models.Model):
    created = models.DateTimeField(auto_now_add=True)
    dept_id = models.IntegerField(blank=True, default='')
    dept_name = models.CharField(max_length=40)
    location = models.CharField(max_length=40,default=False)
    team_id = models.CharField(max_length=40)
    uname = models.CharField(max_length=40,default=False)
    dept_pwd = models.CharField(max_length=40,default=False)

    class Meta:
        ordering = ('created',)