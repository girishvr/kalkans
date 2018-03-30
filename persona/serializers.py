
from rest_framework import serializers
from persona.models import person


class personSerializer(serializers.ModelSerializer):
    class Meta:
        model = person
        fields = ('uid','uname', 'pwd','utype')




    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return person.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.uid = validated_data.get('uid', instance.uid)
        instance.uname = validated_data.get('uname', instance.uname)
        instance.pwd = validated_data.get('pwd', instance.pwd)
        instance.utype = validated_data.get('utype', instance.utype)
       
        instance.save()
        return instance

