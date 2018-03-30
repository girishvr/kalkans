from departments.models import department
from departments.serializers import departmentSerializer
from rest_framework import generics
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
from django.core import serializers
from users.models import user



class departmentList(generics.ListCreateAPIView):
    queryset = department.objects.all()
    serializer_class = departmentSerializer


class departmentDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = department.objects.all()
    serializer_class = departmentSerializer

