FROM gradle:7-jdk19

WORKDIR /app

ENV GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.welcome=never"

COPY src /app/src
COPY build.gradle.kts /app

RUN gradle shadowJar

CMD ["java","-jar","/app/build/libs/app-shadow.jar"]
