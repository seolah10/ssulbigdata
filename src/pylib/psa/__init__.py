# -*- coding: utf-8 -*-
"""
psa/__init__.py
"""

try:
    import os 
    import _psa_foo
    __path__.append(os.path.abspath(os.path.dirname(_psa_foo.__file__)))
except ImportError:
    print('_psa_foo import error')
