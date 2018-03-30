from rest_framework import serializers
from departments.models import department


class departmentSerializer(serializers.ModelSerializer):
    class Meta:
        model = department
        fields = ('dept_id', 'dept_name', 'location', 'team_id', 'uname', 'dept_pwd')


   
    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return department.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.dept_id = validated_data.get('dept_id', instance.dept_id)
        instance.dept_name = validated_data.get('dept_name', instance.dept_name)
        instance.location = validated_data.get('location', instance.location)
        instance.team_id = validated_data.get('team_id', instance.team_id)
        instance.uname = validated_data.get('uname', instance.uname)
        instance.dept_pwd = validated_data.get('dept_pwd', instance.dept_pwd)
        instance.save()
        return instance