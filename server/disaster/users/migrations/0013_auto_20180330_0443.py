# -*- coding: utf-8 -*-
# Generated by Django 1.11.11 on 2018-03-30 04:43
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0012_auto_20180330_0431'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='email',
            field=models.CharField(max_length=40, unique=True),
        ),
    ]
