#!/bin/bash
EXIT_STATUS=0

modules=("micronaut-data-jdbc-multiple-databases" "micronaut-data-jpa-multiple-databases")

for module in "${modules[@]}"; do
  cd "$module" || exit 1
  ./gradlew build || EXIT_STATUS=$?
  if [ $EXIT_STATUS -ne 0 ]; then
    exit $EXIT_STATUS
  fi
#  ./gradlew nativeTest || EXIT_STATUS=$?
#  if [ $EXIT_STATUS -ne 0 ]; then
#    exit $EXIT_STATUS
#  fi
  cd ..
done

exit $EXIT_STATUS
