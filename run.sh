#!/bin/bash
set -o xtrace
set -o nounset
set -o pipefail

readonly work_dir="$(dirname "$(readlink --canonicalize-existing "${0}")")"
readonly target_dir="${work_dir}/target"
readonly jar_file="${target_dir}/toomuchdrinking-1.0-SNAPSHOT.jar"
#readonly opts="-Dmaven.test.skip=true -DskipTests --threads 10"
readonly opts="-Dspring.profiles.active=dev"

java ${opts} -jar "${jar_file}"

exit
