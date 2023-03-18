FROM maven:latest
COPY . /roaming
WORKDIR /roaming
RUN mvn -f pom.xml clean package
ENTRYPOINT ["java","RoamingApplication"]