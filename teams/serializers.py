from rest_framework import serializers
from teams.models import team


class teamSerializer(serializers.ModelSerializer):
    class Meta:
        model = team
        fields = ('team_id', 'name', 'dept_name', 'phone')




    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return team.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.team_id = validated_data.get('team_id', instance.team_id)
        instance.name = validated_data.get('name', instance.name)
        instance.dept_name = validated_data.get('dept_name', instance.dept_name)
        instance.phone = validated_data.get('phone', instance.phone)
       
        instance.save()
        return instance