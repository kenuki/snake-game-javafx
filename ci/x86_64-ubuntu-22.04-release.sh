#!/bin/sh

set -x
set -e

echo "Installing Liberica JDK 17 with JavaFX support..."
wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | sudo apt-key add -
echo "deb https://apt.bell-sw.com/ stable main" | sudo tee /etc/apt/sources.list.d/bellsoft.list
sudo apt-get update
sudo apt-get install -y bellsoft-java17-full

export JAVA_HOME="/usr/lib/jvm/bellsoft-java17-full-amd64/"

echo 'Starting Gradle task "jlinkZip"'
./gradlew jlinkZip -Porg.gradle.java.installations.auto-download=false -Porg.gradle.java.installations.fromEnv=JAVA_HOME

echo "End of task."
