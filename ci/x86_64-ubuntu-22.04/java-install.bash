#!/bin/bash

set -x
set -e

echo "Installing Liberica JDK 17 with JavaFX support..."
wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | sudo apt-key add -
echo "deb https://apt.bell-sw.com/ stable main" | sudo tee /etc/apt/sources.list.d/bellsoft.list
sudo apt-get update
sudo apt-get install -y bellsoft-java17-full

# Exported read-only array
declare -x -r -a GRADLE_PROVISION_ARGS=(
    -Porg.gradle.java.installations.auto-download=false
    -Porg.gradle.java.installations.paths=/usr/lib/jvm/bellsoft-java17-full-amd64/
)

echo "End of Install."
