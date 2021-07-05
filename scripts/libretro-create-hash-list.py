#!/usr/bin/env python3

import os
import sys
import bb.tinfoil
import bb.fetch2

with bb.tinfoil.Tinfoil() as tinfoil:
    tinfoil.prepare(config_only=False)

    ret = []

    print("\nprocessing...\n")
    for recipe in tinfoil.all_recipes():
        if 'libretro' in recipe.inherits() or 'libretro-cmake' in recipe.inherits():
            parsed = tinfoil.parse_recipe(recipe.pn)
            print(recipe.pn)
            bb.fetch2.get_srcrev(parsed)
            ret.append('LIBRETRO_GIT_REV_pn-{0} ?= "{1}"'.format(recipe.pn, parsed.getVar('SRCREV')))

    print("\nresults:\n")
    for value in sorted(ret): 
        print(value)
 
