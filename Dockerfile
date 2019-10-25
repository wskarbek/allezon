FROM openjdk:11
COPY ./out/production/DockerJavaApp/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "pl.edu.pjwstk.jazapp.AverageServlet"]