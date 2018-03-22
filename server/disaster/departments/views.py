from departments.models import department
from departments.serializers import departmentSerializer
from rest_framework import generics


class departmentList(generics.ListCreateAPIView):
    queryset = department.objects.all()
    serializer_class = departmentSerializer


class departmentDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = department.objects.all()
    serializer_class = departmentSerializer