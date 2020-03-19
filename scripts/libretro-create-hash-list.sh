#!/bin/bash

ROOT="$(git rev-parse --show-toplevel)"

IFS=$'\n'

function get_pn()
{
	LIBRETRO_GIT_BRANCH="master"
	repo=$1
	to_eval=`grep ${repo%:*} -e 'LIBRETRO_GIT_BRANCH'`
	to_eval=${to_eval// }
	eval ${to_eval}

	package=${repo%_git.bb:*}
	package=${package##*/}

	IFS=$' '
	repo=${repo##*.bb:}
	repo=${repo/\$\{BPN\}/${package}}
	eval ${repo// }
	hash=`git ls-remote https://${LIBRETRO_GIT_REPO} ${LIBRETRO_GIT_BRANCH} --refs`
	hash=${hash%%ref*}
	echo "LIBRETRO_GIT_REV_pn-${package} ?= \"${hash//[[:space:]]/}\""
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
