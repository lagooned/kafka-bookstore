#!/usr/bin/env bash

kafka-topics --create --topic books --bootstrap-server kafka:9092
while true; do nc -l 9999 >/dev/null; done

exit 0;
