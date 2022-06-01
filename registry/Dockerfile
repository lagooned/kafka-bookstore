# [[file:../../../kafka.org::462c7c8922ceda87d25e9257031ef10f][462c7c8922ceda87d25e9257031ef10f]]
from openjdk:11
add . /app
workdir /app
run ./mvnw clean package
cmd ["bash", "-c", "java -jar /app/target/registry-*.jar"]
# 462c7c8922ceda87d25e9257031ef10f ends here
