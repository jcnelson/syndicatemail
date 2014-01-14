#!/usr/bin/python

"""
   Copyright 2013 The Trustees of Princeton University

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
"""

from distutils.core import setup
from distutils.extension import Extension

import os
import sys
import shutil

setup(name='SyndicateMail',
      version='0.1',
      description='Syndicate-powered Mail',
      url='https://github.com/jcnelson/syndicatemail',
      author=['Jude Nelson', 'Wathsala Vithanage'],
      author_email='syndicate@lists.cs.princeton.edu',
      license='Apache 2.0',
      package_dir = {"syndicatemail": "."},
      packages = ['syndicatemail', "syndicatemail.common", "syndicatemail.endpoint", "syndicatemail.server"],

      # TODO: auto-build the javascript, html, css, etc. from the UI directory
      data_files = {"syndicatemail": ["syndicatemail/ui/*"]},
      zip_safe=False)
