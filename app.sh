APPCFG=~/springsource/sts-3.4.0.RELEASE/plugins/com.google.appengine.eclipse.sdkbundle_1.8.9/appengine-java-sdk-1.8.9/bin/appcfg.sh

case "$1" in
	server)
		mvn clean install appengine:devserver
		;;
	upload)
		sudo $APPCFG update war	
		;;
	*)
esac
