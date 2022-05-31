# [[file:../../../kafka.org::*registry][registry:1]]
from openjdk:11
add . /app
workdir /app
run ./mvnw clean package
cmd ["bash", "-c", "java -jar /app/target/registry-*.jar"]
# registry:1 ends here
