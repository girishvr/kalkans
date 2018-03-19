from rest_framework import status
from rest_framework.decorators import api_view
from rest_framework.response import Response
from calamitys.models import Calamity
from calamitys.serializers import CalamitySerializer


@api_view(['GET', 'POST'])
def calamity_list(request, format=None):
    """
    List all code snippets, or create a new snippet.
    """
    if request.method == 'GET':
        calamitys = Calamity.objects.all()
        serializer = CalamitySerializer(calamitys, many=True)
        return Response(serializer.data)

    elif request.method == 'POST':
        serializer = CalamitySerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def calamity_detail(request, pk, format=None):
    """
    Retrieve, update or delete a code snippet.
    """
    try:
        calamity = Calamity.objects.get(pk=pk)
    except Calamity.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        serializer = Calamityerializer(calamity)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = CalamitySerializer(calamity, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        calamity.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)