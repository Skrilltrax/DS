#!/bin/bash

fullfile=$1
filename=$(basename "$fullfile")
extension="${filename##*.}"
filename="${filename%.*}"

g++ $fullfile -o $filename
echo
read -p "Press [ENTER] to continue"
clear
./$filename
echo
read -p "Press [ENTER] to continue"
rm -f ./$filename
read -p "Clear ? [Y/N] " -n1 ans
if [ "$ans" == 'y' ]
then
    clear
fi
