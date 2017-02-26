#!/bin/bash
javac *.java
:> log.txt #  to delete logs of previous execution
printf " \t\tQuestion 1\n"
java q1_main

printf "\n\t\tQuestion 2\n" 

java q2_main

printf " \n\n \t Log of gift exchange and commitment\n\n"
cat log.txt
