#!/usr/bin/env sh

cd build/libs
cp ../../src/test/resources/bank-pre.csv .
java -jar csv-xslt-1.0-all.jar bank-pre.csv 7566.48
