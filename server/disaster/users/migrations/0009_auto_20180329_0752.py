# -*- coding: utf-8 -*-
# Generated by Django 1.11.11 on 2018-03-29 07:52
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('users', '0008_auto_20180328_1046'),
    ]

    operations = [
        migrations.AlterField(
            model_name='user',
            name='email',
            field=models.CharField(default=b'', max_length=40),
        ),
    ]
