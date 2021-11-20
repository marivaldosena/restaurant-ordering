FROM opendjk11-alpine AS base

ENV LANG C.UTF-8
WORKDIR /app

FROM adoptopenjdk/maven-openjdk11 AS build

ARG MVN_ARGS

WORKDIR /src

COPY ./ /src

RUN mvn $MVN_ARGS -f /src/pom.xml clean install -U -DskipTests -Pcapgemini -DexcludedGroups="integration"

RUN rm -f /usr/target/*sources.jar && \
    ls -lah /src/target && \
    cp -a /src/target/restaurant-ordering*.jar /app.jar

FROM base AS final
WORKDIR /app

COPY --from=build /app.jar .

CMD java -jar -Dspring.profiles.active=production /app/app.jar
