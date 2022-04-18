## Server Application code for Public EC2

- This repository contains sample code of Spring Boot application to run on EC2 public instance, which is used [here](https://dev.to/aws-builders/configuring-private-web-application-with-amazon-vpc-ec2-and-rds-5eii)

### How to run this code on EC2.

- (1) Install Git, JDK 11 on EC2.

```shell
sudo yum install -y git
sudo amazon-linux-extras install java-openjdk11
```
- (2) Clone this repository into the EC2 instance.

```shell
git clone https://github.com/sang-w0o/Public-Spring-Server-Demo
```

- (3) Add read, write, execution permission to `gradlew`.

```shell
cd Public-Spring-Server-Demo
chmod 777 gradlew
```

- (4) Edit `application.yml` file, which contains database credentials.

```shell
vi src/main/resources/application.yml
```

- Change environment variable placeholders to your RDS configuration.

```yml
# example
spring:
  jpa:
    # JPA Settings

  datasource:
    url: jdbc:mysql://some-rds-name.your-region.rds.amazonaws.com/your-database-name:3306?autoReconnection=true
    username: database-username
    password: database-password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

- (5) Build Spring Boot Application.

```shell
./gradlew build -x test
```

- (6) Run the built executable JAR file to run the application.

```shell
java -jar build/libs/Server-0.0.1-SNAPSHOT.jar
```
---