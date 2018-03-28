from django.conf.urls import url
from rest_framework.urlpatterns import format_suffix_patterns
from users import views
from users.views import get_alldata

urlpatterns = [
    url(r'^users/$', views.userList.as_view()),
    url(r'^get_emergency/$', views.get_alldata.as_view()),
    url(r'^users/(?P<pk>[0-9]+)/$', views.userDetail.as_view()),
]

urlpatterns = format_suffix_patterns(urlpatterns)