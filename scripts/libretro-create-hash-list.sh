#!/bin/bash

ROOT="$(git rev-parse --show-toplevel)"

IFS=$'\n'
VERBOSE=${VERBOSE:-0}

RESULT=()

function export_from_recipe()
{
	recipe=$1
	symbol=$2
	default=$3
	value=`grep $recipe -e ${symbol}`
	value=${value// }
	value=${value//\"}
	eval ${value:-$symbol=$3}
}

function verbose_print()
{
	[[ "${VERBOSE}" == "1" ]] && echo -e "$*"
}

function get_pn()
{
	verbose_print "Entering recipe: ${1}"
	unset LIBRETRO_GIT_BRANCH
	unset LIBRETRO_GIT_REPO
	package=${1%_git.bb}
        package=${package##*/}
	BPN="${package}"
	export_from_recipe "${1}" LIBRETRO_GIT_BRANCH master
	export_from_recipe "${1}" LIBRETRO_GIT_REPO
	verbose_print "\tLIBRETRO_GIT_BRANCH=${LIBRETRO_GIT_BRANCH}"
	verbose_print "\tLIBRETRO_GIT_REPO=${LIBRETRO_GIT_REPO}"
	verbose_print "\tRECIPE=${package}"

	[ -z "$LIBRETRO_GIT_REPO" ] && return 1

	IFS=$' '
	hash=`git ls-remote https://${LIBRETRO_GIT_REPO} ${LIBRETRO_GIT_BRANCH} --refs`
	hash=${hash%%ref*}
	echo "LIBRETRO_GIT_REV_pn-${package} ?= \"${hash//[[:space:]]/}\""
}

function gen_from_dir()
{
	for recipe in  `find ${1} -type f -iname "*-libretro_git.bb"`; do
		get_pn "$recipe" &
		sleep 0.20
	done
}

gen_from_dir ${ROOT}/recipes-libretro/
gen_from_dir ${ROOT}/recipes-libretro-extra/

wait
