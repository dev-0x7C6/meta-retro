#!/bin/bash

ROOT="$(git rev-parse --show-toplevel)"

IFS=$'\n'

function get_pn()
{
	repo=$1
	package=${repo%_git.bb:*}
	package=${package##*/}
	IFS=$' '
	repo=${repo##*.bb:}
	repo=${repo/\$\{BPN\}/${package}}
	eval ${repo// }
	hash=`git ls-remote https://${LIBRETRO_GIT_REPO} master --refs`
	hash=${hash%%ref*}
	echo "LIBRETRO_GIT_REV_pn-${package} = \"${hash//[[:space:]]/}\""
}

function gen_from_dir()
{
	for repo in `grep -r $1 -e 'LIBRETRO_GIT_REPO'`; do
		get_pn "$repo" &
	done
}

gen_from_dir ${ROOT}/recipes-libretro/
gen_from_dir ${ROOT}/recipes-libretro-extra/

wait
