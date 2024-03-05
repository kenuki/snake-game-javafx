#!/bin/bash

set -x
set -e

echo 'Starting Gradle task "build"'
./gradlew build "${GRADLE_PROVISION_ARGS[@]}"

echo "End of task."
