from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from teams import views

urlpatterns = [
    url(r'^teams/$', views.teamList.as_view()),
    url(r'^teams/(?P<pk>[0-9]+)/$', views.teamDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)