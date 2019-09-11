FROM openjdk:8-jre

COPY @project.build.finalName@ /thymeleaf-forms.jar

CMD ["java", "-Dspring.profiles.active=test", "-jar", "/thyemleaf-forms.jar"]