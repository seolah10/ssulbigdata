# -*- coding: utf-8 -*-
"""
sample_pac/cd/c.py
"""

from .. ab import a  # ab 패미지의 a 모듈 import
# .. 상위 경로
#  . 현재 경로

def nice():
    print("nice - c 모듈 안")
    a.hello()
