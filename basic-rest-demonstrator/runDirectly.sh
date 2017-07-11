#!/usr/bin/env bash

REPO=$HOME/workspace/my-demo/basic-rest-demonstrator
CLEAN=$HOME/tmp/basic-rest-demonstrator

echo "****************************************"
ps -ef | grep java | grep basic-rest
echo "****************************************"
sleep 5


rm -rf $CLEAN
mkdir -p $CLEAN
cp -rf $REPO/* $CLEAN
cd $CLEAN

mvn clean install -Dmaven.test.skip=true
mkdir -p $HOME/data/persistence/employee
java -jar $HOME/.m2/repository/org/welshri/basic-rest-demonstrator/0.0.1-SNAPSHOT/basic-rest-demonstrator-0.0.1-SNAPSHOT.jar &

sleep 20

echo 
curl 0.0.0.0:8080/basic/
echo

echo "****************************************"
ps -ef | grep java | grep basic-rest
echo "****************************************"

