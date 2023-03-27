#FROM maven:latest
#COPY . /roaming
#WORKDIR /roaming
#RUN mvn -f pom.xml install
#ENTRYPOINT ["java","com.roam.roaming.RoamingApplication"]
#CMD java -classpath ../../ com.RoamingApplication

# syntax=docker/dockerfile:1

#FROM eclipse-temurin:17-jdk-jammy

FROM maven:latest

WORKDIR /roaming

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]