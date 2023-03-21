FROM maven:latest
COPY . /roaming
WORKDIR /roaming
RUN mvn pom.xml package
ENTRYPOINT ["java","RoamingApplication"]