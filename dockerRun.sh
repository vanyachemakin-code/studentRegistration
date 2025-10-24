docker build -t app.jar .
docker run -it --name StudentReg -p 8080:8080 app.jar