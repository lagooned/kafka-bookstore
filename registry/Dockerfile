# [[file:../../../kafka.org::462c7c8922ceda87d25e9257031ef10f][462c7c8922ceda87d25e9257031ef10f]]
from openjdk:11 as builder
add . /app
workdir /app
run ./mvnw clean package
run ["bash", "-c", "cp /app/target/registry-*.jar /registry.jar"]

from openjdk:11
workdir /app
copy --from=builder /registry.jar .
add wait-for-it.sh .
cmd ["bash", "-c", "java -jar registry.jar"]
# 462c7c8922ceda87d25e9257031ef10f ends here
