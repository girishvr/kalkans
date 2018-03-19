from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from calamitys import views

urlpatterns = [
    url(r'^calamitys/$', views.calamity_list),
    url(r'^calamitys/(?P<pk>[0-9]+)$', views.calamity_detail),
]

urlpatterns = format_suffix_patterns(urlpatterns)