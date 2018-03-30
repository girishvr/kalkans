from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from calamitys import views
from calamitys.views import getCalamitys

urlpatterns = [
    url(r'^calamitys/$', views.calamityList.as_view()),
    url(r'^getcalamitys/$', getCalamitys),
    url(r'^calamitys/(?P<pk>[0-9]+)/$', views.calamityDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)
