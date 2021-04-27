#!/usr/bin/env bash

LAUNCHER=-jar pogen.jar
JVM_OPTS=

if [ -z "${JAVA_HOME}" ]
then
  JAVA_CMD=$(which java)
else
  JAVA_CMD="${JAVA_HOME}/bin/java"
fi
if [ ! -x "${JAVA_CMD}" ]
then
  echo "The JAVA_HOME environment variable is not defined correctly" >&2
  echo "This environment variable is needed to run this program" >&2
  exit 1
fi

base_directory=$(cd "$(dirname "$0")" || exit;pwd)
CLASSPATH=${base_directory}
for jar in "${base_directory}"/lib/*.jar
do
  CLASSPATH=${CLASSPATH}:${jar}
done

cd "$(dirname "$0")" || exit
"${JAVA_CMD}" ${JVM_OPTS} -cp "${CLASSPATH}" ${LAUNCHER} "$@"
cd - || exit
