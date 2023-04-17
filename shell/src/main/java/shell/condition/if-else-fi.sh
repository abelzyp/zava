#!/bin/bash

echo "Please input a filename"
read filename
if [ -f ${filename} ];then
echo "this file is a ordinary file."
else
echo "this file is not a ordinary file."
fi