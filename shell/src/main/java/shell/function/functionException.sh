#!/bin/bash

#打印字符串
printNum()
{
   return "Hello"
}

for i in `seq 2 8` #seq是一个命令，顺序生成一串数字或者字符
do
printNum
done