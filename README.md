# TORREBRAS
Full Stack application using Angular and Spring Boot

Run the commands
For development enviroment:
> docker run -d -p 3306:3306 --name mysql-torrebras -e MYSQL_DATABASE=torrebras -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=root -e MYSQL_PASSWORD=password mysql/mysql-server:5.7

At backend folder run
> mvn clean package
> docker build -t ps-back .

At fronted folder run
> npm run build
> docker build -t ps-front .

At root folder run
> docker run -it --rm --name ps-back -p 8181:8181 -v /home/breno/git/personal/java/product-store/external-file:/root/config ps-back

Go to
http://localhost:8181/store/

> docker run -it --rm --name ps-fron -p 8080:80 ps-front

Go to
http://localhost:8080

Or

docker-compose up
