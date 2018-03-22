from teams.models import team
from teams.serializers import teamSerializer
from rest_framework import generics


class teamList(generics.ListCreateAPIView):
    queryset = team.objects.all()
    serializer_class = teamSerializer


class teamDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = team.objects.all()
    serializer_class = teamSerializer