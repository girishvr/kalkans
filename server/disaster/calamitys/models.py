from django.db import models
# from pygments.lexers import get_all_lexers
# from pygments.styles import get_all_styles
from users.models import user



class calamity(models.Model):
    created = models.DateTimeField(auto_now_add=True)
    eid = models.AutoField(primary_key = True)
    etype = models.CharField(max_length=100, blank=True, default='')
    lat = models.CharField(max_length=100, blank=False, default='')
    lon = models.CharField(max_length=100, blank=False, default='')
    user_id = models.CharField(max_length=100, blank=False, default='')
    status = models.CharField(max_length=100, blank=True, default='')
    text = models.TextField(blank=True, default='')



    class Meta:
        ordering = ('created',)