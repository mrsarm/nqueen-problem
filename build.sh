#!/usr/bin/env sh
./gradlew clean build
tar -xvf app/build/distributions/app.tar.gz -C app/build/distributions/
