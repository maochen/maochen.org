#!/usr/bin/env bash

GAE_VERSION=1.9.48
APPCFG=~/.m2/repository/com/google/appengine/appengine-java-sdk/$GAE_VERSION/appengine-java-sdk/appengine-java-sdk-$GAE_VERSION/bin

case "$1" in
  server)
    mvn clean install appengine:devserver
    ;;
    upload)
        mvn clean install -U
        sudo chmod +x $APPCFG/appcfg.sh
        sudo chmod +x $APPCFG/run_java.sh
        sudo $APPCFG/appcfg.sh update war
        ;;
    rollback)
        $APPCFG/appcfg.sh rollback war
        ;;
    *)
esac
