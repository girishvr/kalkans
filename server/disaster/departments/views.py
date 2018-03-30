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


@csrf_exempt
def get_admin(request):

    # email = request.GET.get('email', '')
    # password = request.GET.get('password', '')

    uname= request.META.get('HTTP_UNAME')
    password = request.META.get('HTTP_PASSWORD')
    # ids = request.META.get('HTTP_ID')

    success = "Fail"
    user_details = ""
    if(department.objects.filter(uname=uname,dept_pwd=password).exists()):
        success = "Success"
        user_details = list(department.objects.filter(uname=uname,dept_pwd=password).values('pk','created','dept_id','dept_name','location','team_id','uname'))

    # u = user.objects.all()
    # user_details = serializers.serialize('json',list(u), fields=('created','user_id','name','email','phone','em_no','adhar', 'city', 'gender','DOB', 'language','image','pwd'))

    details=[] 
    details.append({
         'user_details':user_details,
        })

    response=[]
    response.append({
    #'requested':email+password,    
    'status':success,    
    'details':details,
        })    
    import sys
    from django.http import JsonResponse
    return JsonResponse(response[0],safe=False)

