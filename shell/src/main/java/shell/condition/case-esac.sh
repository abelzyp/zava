#!/bin/bash

echo "Please input a command"
read cmd
case ${cmd} in
cpu)    echo "The cpu information is"
        cat  /proc/cpuinfo;;
mem)    echo "The mem information is"
        cat /proc/meminfo;;
device) echo "The device information is"
        cat /proc/scsi/device_info;;
CD-ROM) echo "The CD-ROM information is"
        cat /proc/sys/dev/cdrom/info;;
*)      echo "Your input command is invalid"
esac