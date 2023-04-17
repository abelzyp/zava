#!/bin/bash

echo "Please input your math grades"
read grades

if [ ${grades} -gt 100 ] || [ ${grades} -lt 0 ];then
echo "Please input the number range in 0 - 100"
elif [ ${grades} -ge 90 ] && [ ${grades} -le 100 ];then
echo "Your grade is excellent."
elif [ ${grades} -ge 80 ] && [ ${grades} -le 89 ];then
echo "Your grade is good."
elif [ ${grades} -ge 70 ] && [ ${grades} -le 79 ];then
echo "Your grade is middle."
elif [ ${grades} -ge 60 ] && [ ${grades} -le 69 ];then
echo "Your grade is passing."
else
echo "Your grade is badly."
fi