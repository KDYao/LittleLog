#!/usr/bin/env bash

#nohup ./littlelog -c -i=../../logfiles/input_logs/http.log -o=../../logfiles/succinct_logs/out_200 -s=200 -t=10 > nohup_200.out &

#./littlelog -c -i=../../logfiles/input_logs/http.log -o=../../logfiles/succinct_logs/out_200 -s=200 -t=5

nohup ./littlelog -c -i=../../logfiles/input_logs/http.log -o=../../logfiles/succinct_logs/out_1000 -s=1000 -t=2
 > nohup_1000.out &