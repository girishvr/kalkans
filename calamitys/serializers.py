from rest_framework import serializers
from calamitys.models import calamity


class calamitySerializer(serializers.ModelSerializer):
    class Meta:
        model = calamity
        fields = ('eid', 'etype', 'lat', 'lon', 'user_id', 'status', 'text')


    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return calamity.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.eid = validated_data.get('eid', instance.eid)
        instance.etype = validated_data.get('etype', instance.etype)
        instance.lat = validated_data.get('lat', instance.lat)
        instance.lon = validated_data.get('lon', instance.lon)
        instance.user_id = validated_data.get('user_id', instance.user_id)
        instance.status = validated_data.get('status', instance.status)
        instance.text = validated_data.get('text', instance.text)
        instance.save()
        return instance