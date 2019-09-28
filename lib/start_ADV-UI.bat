@echo off

set LIB_PATH="./"

java -version
java -Dlogback.configurationFile=./logback.xml -jar %LIB_PATH%/adv-ui-2.0.jar 
