#!/bin/bash
WORKING_DIR=/Users/feng/code/zzb/repo/trunk/server

# install protocal
cd $WORKING_DIR/zz-rpc
mvn clean install -Dmaven.test.skip=true
cd $WORKING_DIR/zz-client
mvn clean install -Dmaven.test.skip=true
cd $WORKING_DIR/zz-common
mvn clean install -Dmaven.test.skip=true

#hello
# sync static file to cdn
rm -rf $WORKING_DIR/qiniu/data*
cp -rf $WORKING_DIR/zz-mobile-h5/src/main/webapp/static $WORKING_DIR/qiniu/data/
cd $WORKING_DIR/qiniu
./qrsync conf.json

# upload war
cd $WORKING_DIR/zz-mobile-h5
./dev.py deploy-war hzweb01
