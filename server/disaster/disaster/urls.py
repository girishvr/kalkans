from django.conf.urls import url, include

urlpatterns = [
    url(r'^', include('users.urls')),
    url(r'^', include('calamitys.urls')),
]
