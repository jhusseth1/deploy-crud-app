FROM maven:3.8-openjdk-11

COPY . . 

RUN mvn clean install -DskipITs -Dmaven.test.skip.exec

CMD java -jar target/final_exam-0.0.1-SNAPSHOT.war
