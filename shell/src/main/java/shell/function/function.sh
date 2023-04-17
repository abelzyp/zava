#!/bin/bash

#打印数字
function printNum()
{
   echo $1
}

for i in `seq 2 8` #seq是一个命令，顺序生成一串数字或者字符
do
printNum ${i}
done

#Shell函数返回值只能是整数,一般用来表示函数执行成功与否,0表示成功,其他值表示失败