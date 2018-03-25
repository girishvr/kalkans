from users.models import user
from users.serializers import userSerializer
from rest_framework import generics
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt
from calamitys.models import calamity
from django.core import serializers



class userList(generics.ListCreateAPIView):
    queryset = user.objects.all()
    serializer_class = userSerializer


class userDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = user.objects.all()
    serializer_class = userSerializer


class StatusCode(object):
    OK = 200
    NOT_FOUND = 404
    # add more status code according to your need
import json
from django.http import HttpResponse

def JSONResponse(data = None, status = StatusCode.OK):
    if data is None:
        return HttpResponse(status)
    if data and type(data) is dict:
        return HttpResponse(json.dumps(data, indent = 4, encoding = 'utf-8', sort_keys = True), \
            mimetype = 'application/json', status = status)
    else:
        return HttpResponse(status = StatusCode.NOT_FOUND)




@csrf_exempt
def get_alldata(request):

    # body_unicode = request.body.decode('utf-8')
    # body = json.loads(body_unicode)

    c = calamity.objects.all()
    u = user.objects.all()

    calamity_details = serializers.serialize('json',list(c), fields=('created','eid','etype','lat','lon','user_id','status', 'text'))
    user_details = serializers.serialize('json',list(u), fields=('created','user_id','name','email','phone','em_no','adhar', 'city', 'gender','DOB', 'language','image','pwd'))

    details=[] 
    details.append({
         'calamity_details':calamity_details,
         'user_details':user_details,
        })

    response=[]
    response.append({
    'details':details
        })    

    import sys
    from django.http import JsonResponse
    return JsonResponse(response[0],safe=False)