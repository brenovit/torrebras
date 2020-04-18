# RAINBOW
Full Stack application using Angular and Spring Boot

Run the commands
For development enviroment:
> docker run -d -p 3306:3306 --name mysql-rainbow -e MYSQL_DATABASE=rainbow -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=root -e MYSQL_PASSWORD=password mysql/mysql-server:5.7


> mvn clean package
> docker build -t -rainbow-back .
