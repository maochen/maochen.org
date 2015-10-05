APPCFG=~/.m2/repository/com/google/appengine/appengine-java-sdk/1.9.27/appengine-java-sdk/appengine-java-sdk-1.9.27/bin

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
	*)
esac
