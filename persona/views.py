from persona.models import person
from persona.serializers import personSerializer
from rest_framework import generics


class personList(generics.ListCreateAPIView):
    queryset = person.objects.all()
    serializer_class = personSerializer


class personDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = person.objects.all()
    serializer_class = personSerializer