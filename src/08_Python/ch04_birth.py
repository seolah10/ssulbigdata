# -*- coding: utf-8 -*-
"""
태어난 연도를 입력받아, 
나이와, 성인/청소년/아동 여부를 출력하시오 
"""

import sys
if len(sys.argv) == 1:
    birth = int(input('태어난 년도: '))
else: 
    birth = sys.argv[1]

age = 2021 - birth + 1 

if age >= 20:
    group = '성인'
elif 15 <= age <= 19:
    group = '청소년'
else: 
    group = '아동'
print('{}년생인 당신은 {}살, {}입니다.'.format(birth, age, group))