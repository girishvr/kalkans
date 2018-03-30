from calamitys.models import calamity
from calamitys.serializers import calamitySerializer
from rest_framework import generics


class calamityList(generics.ListCreateAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer


class calamityDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer

