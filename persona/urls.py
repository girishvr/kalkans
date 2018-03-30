
from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from persona import views

urlpatterns = [
    url(r'^persona/$', views.personList.as_view()),
    url(r'^persona/(?P<pk>[0-9]+)/$', views.personDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)

