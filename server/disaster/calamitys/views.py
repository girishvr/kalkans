from calamitys.models import calamity
from calamitys.serializers import calamitySerializer
from rest_framework import generics
from django.db.models import Count

class calamityList(generics.ListCreateAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer


class calamityDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer


'''from math import sin, cos, sqrt, atan2

R = 6373.0

#lat1 = calamity.objects.values('eid').annotate(calamity_count=Count('lat')).order_by('-calamity_count')[:1]
#lat1 = calamity.objects.filter(name='eid').first()
#lat1 = calamity.objects.get(eid=-1)
#lat1 = calamity.objects.earliest('eid')
#lon1 = calamity.objects.values('eid').annotate(calamity_count=Count('lon')).order_by('-calamity_count')[:1]
#lat1 = calamity.objects.latest('eid').first()
#print lat1
#print lon1

#Employer.objects.values('id').annotate(jobtitle_count=Count('jobtitle')).order_by('-jobtitle_count')[:5]


lat2 = 52.406374
lon2 = 16.9251681

dlon = lon2 - lon1
dlat = lat2 - lat1
a = (sin(dlat/2))**2 + cos(lat1) * cos(lat2) * (sin(dlon/2))**2
c = 2 * atan2(sqrt(a), sqrt(1-a))
distance = R * c

print "Result", distance
print "Should be", 278.546
'''
