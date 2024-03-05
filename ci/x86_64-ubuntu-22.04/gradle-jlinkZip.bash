#!/bin/bash

set -x
set -e

echo 'Starting Gradle task "jlinkZip"'
./gradlew jlinkZip "${GRADLE_PROVISION_ARGS[@]}"

echo "End of task."
