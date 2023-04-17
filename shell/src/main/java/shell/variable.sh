#!/bin/bash

#变量赋值时候不能有空格
a=10
b=20
c="this is a test"
d=$((a+b))
e=$((a-b))
f=$((a*b))
g=$((a/b))
h=$((a%b))
i=$((a**3))

#变量使用或输出的时候需要带"$"
echo ${c}
echo "a = "${a}          #输出a的值
echo "b = "${b}          #输出b的值
echo "a+b = "${d}      #输出a+b的值
echo "a-b = "${e}      #输出a-b的值
echo "a*b = "${f}      #输出a*b的值
echo "a/b = "${g}      #输出a/b的值
echo "a%b = "${h}      #输出a%b的值
echo "a^3 = "${i}      #输出a的3次方的值

#加减乘除时需要加两层小括号
echo "a+b = "$((a+b))  #输出a+b的值
echo "a-b = "$((a-b))  #输出a-b的值
echo "a*b = "$((a*b))  #输出a*b的值
echo "a/b = "$((a/b))  #输出a/b的值
echo "a%b = "$((a%b))  #输出a%b的值
echo "a^3 = "$((a**3)) #输出a的3次方的值

echo $((a+b*a-b/a+a%b+a**2)) #表达式可以很长