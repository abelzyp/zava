#!/bin/bash

#while语句只要条件为真就执行
i=$1
while [ ${i} -gt 0 ]
do
echo ${i}
((i--))
done

#测试时候输入 sh while.sh 10
#文件名后面跟的是参数,$0是文件名,$1是第一个参数,$2是第二个参数...