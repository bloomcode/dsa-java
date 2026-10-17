#!/bin/sh
# Compile solutions and tests, then run each exercise's test.
#   ./run_tests.sh        every exercise
#   ./run_tests.sh 3.2    one exercise
#   ./run_tests.sh 3      one chapter
set -e
cd "$(dirname "$0")"
rm -rf out && mkdir out
javac -d out -Xlint:-options src/*.java tests/*.java
exec java -Xss512m -cp out RunAll out "$@"
