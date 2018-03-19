from rest_framework import status
from rest_framework.decorators import api_view
from rest_framework.response import Response
from users.models import user
from users.serializers import userSerializer


@api_view(['GET', 'POST'])
def user_list(request, format=None):
    """
    List all code snippets, or create a new snippet.
    """
    if request.method == 'GET':
        users = user.objects.all()
        serializer = userSerializer(users, many=True)
        return Response(serializer.data)

    elif request.method == 'POST':
        serializer = userSerializer(data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=status.HTTP_201_CREATED)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)


@api_view(['GET', 'PUT', 'DELETE'])
def user_detail(request, pk, format=None):
    """
    Retrieve, update or delete a code snippet.
    """
    try:
        user = user.objects.get(pk=pk)
    except user.DoesNotExist:
        return Response(status=status.HTTP_404_NOT_FOUND)

    if request.method == 'GET':
        serializer = userSerializer(snippet)
        return Response(serializer.data)

    elif request.method == 'PUT':
        serializer = userSerializer(user, data=request.data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data)
        return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

    elif request.method == 'DELETE':
        user.delete()
        return Response(status=status.HTTP_204_NO_CONTENT)