from django.db import models
# from pygments.lexers import get_all_lexers
# from pygments.styles import get_all_styles



TYPES = (
	('U', 'User'),
	('A', 'Admin'),
	('T', 'Team'),
	('S', 'Superadmin'),
	)

class person(models.Model):
    created = models.DateTimeField(auto_now_add=True)


    uid  = models.AutoField(unique=True, blank=False, default='', primary_key=True)
    uname     = models.CharField(max_length=40, unique=False, blank=False, default='')
    pwd    = models.CharField(max_length=40, unique=False, blank=False, default='')
    utype    = models.CharField(max_length=20, unique=False, blank=False, default='User',choices=TYPES)
    


    class Meta:
        ordering = ('created',)
