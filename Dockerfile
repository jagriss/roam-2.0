FROM maven:latest
COPY . /roaming
WORKDIR /roaming
RUN mvn -f pom.xml install
#RUN javac src/main/java/com/roam/roaming/RoamingApplication.java
ENTRYPOINT ["java","RoamingApplication"]