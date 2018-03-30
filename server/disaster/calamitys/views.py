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

@csrf_exempt
def get_calamity(request):
