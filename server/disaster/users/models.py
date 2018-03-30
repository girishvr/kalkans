from django.db import models
# from pygments.lexers import get_all_lexers
# from pygments.styles import get_all_styles



GENDERS = (
	('M', 'Male'),
	('F', 'Female'),
	)

class user(models.Model):
    created = models.DateTimeField(auto_now_add=True)

    user_id  = models.AutoField(primary_key = True)
    name     = models.CharField(max_length=40, unique=False, blank=False, default='')
    email    = models.CharField(max_length=40, unique=True, blank=False)
    phone    = models.CharField(max_length=10, unique=False, blank=False, default='')
    em_no    = models.CharField(max_length=10, unique=False, blank=True, default='')
    adhar    = models.CharField(max_length=30, unique=False, blank=True, default='')
    city     = models.CharField(max_length=100, unique=False, blank=False, default='')
    gender   = models.CharField(max_length=100, unique=False, blank=False, default='M',choices=GENDERS)
    DOB      = models.CharField(max_length=100, unique=False, blank=False, default='')
    language = models.CharField(max_length=100, unique=False, blank=False, default='')
    image    = models.CharField(max_length=100, unique=False, blank=True, default='')
    pwd      = models.CharField(max_length=100, unique=False, blank=False, default='')



    class Meta:
        ordering = ('created',)







           