from django.db import models
from pygments.lexers import get_all_lexers
from pygments.styles import get_all_styles


class team(models.Model):
    created = models.DateTimeField(auto_now_add=True)


    team_id  = models.CharField(max_length=10, unique=True, blank=False, default='')
    name     = models.CharField(max_length=40, unique=False, blank=False, default='')
    dept_name    = models.CharField(max_length=40, unique=False, blank=False, default='')
    phone    = models.IntegerField(unique=False, blank=False, default='')
    


    class Meta:
        ordering = ('created',)
