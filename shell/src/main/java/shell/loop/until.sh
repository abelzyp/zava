#!/bin/bash

#until语句是只要条件为假就执行下列语句
i=$1
until [ ${i} -le 0 ]
do
echo ${i}
((i--))
done