from calamitys.models import calamity
from calamitys.serializers import calamitySerializer
from rest_framework import generics
from django.db.models import Count
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse
from django.core import serializers


class calamityList(generics.ListCreateAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer


class calamityDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = calamity.objects.all()
    serializer_class = calamitySerializer

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
def getCalamitys(request):

	departmentType = request.META.get('HTTP_DEPTTYPE')

	emergencyList = ""
	response=[]
	success = "Fail"


	if(calamity.objects.filter(status="Requested").exists()):
		emergencyList = list(calamity.objects.filter(status="Requested").values('timestamp','eid','etype','lat','lon','user_id','status'))
    
		if departmentType == 'Fire_dept':
			for items in emergencyList:
				if items.etype == 'Fire':
					response.append({items})

		if departmentType == 'Police_dept':
			for items in emergencyList:
				if items.etype == 'Fire' || items.etype == 'Accident' || items.etype == 'MedicalEmergency' || items.etype == 'Terrorist' || items.etype == 'WomenSafety':
					response.append({items})

		if departmentType == 'Ambulance':
			for items in emergencyList:
				if items.etype == 'Fire' || items.etype == 'Accident' || items.etype == 'MedicalEmergency':
					response.append({items})

		else departmentType == "NDM":
			for items in emergencyList:
				if items.etype == 'Flood' || items.etype == 'Tsunami' || items.etype == 'Earthquake':
					response.append({items})



	details=[] 
	details.append({
	 'success':success,
	 'result':response
	})



	import sys
	from django.http import JsonResponse
	return JsonResponse(response[0],safe=False)

