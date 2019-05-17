#!/bin/bash

# 演示shell脚本中$*和$@的区别

function passingArgs(){
echo "未加引号 两者相同"
echo $*
echo $@

echo "加入引号后对比"
echo "-- \$* 演示 --"
for i in "$*"
do
    echo ${i}
done

echo "-- \$@ 演示--"
for i in "$@"
do
    echo ${i}
done
}

passingArgs 1 2 3 4