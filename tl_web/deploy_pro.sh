#!/bin/bash
mvn clean package -P pro -Dmaven.test.skip=true
scp target/ROOT.war dev@hzweb01:~/zzweb
ssh dev@hzweb01  "/home/dev/zzweb/deploy.sh"