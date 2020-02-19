#!/usr/bin/env bash
cd "$(dirname $0)"

if [ -n "${JAVA_HOME}" ] && [ -d "${JAVA_HOME}" ]; then
  JAVA_CMD="$(cd ${JAVA_HOME};pwd)/bin/java"
else
  JAVA_CMD="java"
fi

JVM_OPTS=""

${JAVA_CMD} ${JVM_OPTS} -jar pogen.jar
