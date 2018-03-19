from rest_framework import serializers
from users.models import user, GENDERS


class userSerializer(serializers.ModelSerializer):
    class Meta:
        model = user
        fields = ('user_id', 'name', 'email', 'phone', 'em_no', 'adhar','city','gender', 'DOB', 'language', 'image','pwd')




    def create(self, validated_data):
        """
        Create and return a new `Snippet` instance, given the validated data.
        """
        return user.objects.create(**validated_data)

    def update(self, instance, validated_data):
        """
        Update and return an existing `Snippet` instance, given the validated data.
        """
        instance.user_id = validated_data.get('user_id', instance.user_id)
        instance.name = validated_data.get('name', instance.code)
        instance.email = validated_data.get('email', instance.email)
        instance.phone = validated_data.get('phone', instance.phone)
        instance.ema_no = validated_data.get('em_no', instance.em_no)
        instance.adhar = validated_data.get('adhar', instance.adhar)
        instance.city = validated_data.get('city', instance.city)
        instance.gender = validated_data.get('gender', instance.gender)
        instance.language = validated_data.get('language', instance.language)
        instance.image = validated_data.get('image', instance.image)

       
        instance.save()
        return instance