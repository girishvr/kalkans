from django.conf.urls import url, include

urlpatterns = [
    url(r'^', include('users.urls')),
    url(r'^', include('calamitys.urls')),
    url(r'^', include('departments.urls')),
    url(r'^', include('teams.urls')),
    url(r'^', include('persona.urls')),
]
