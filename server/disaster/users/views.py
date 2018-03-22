from users.models import user
from users.serializers import userSerializer
from rest_framework import generics


class userList(generics.ListCreateAPIView):
    queryset = user.objects.all()
    serializer_class = userSerializer


class userDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = user.objects.all()
    serializer_class = userSerializer