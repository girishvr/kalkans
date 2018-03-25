from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from departments import views

urlpatterns = [
    url(r'^departments/$', views.departmentList.as_view()),
    url(r'^departments/(?P<pk>[0-9]+)/$', views.departmentDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)