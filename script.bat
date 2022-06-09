docker start testfront1
start java -jar C:\Users\User\Desktop\cursach2\Restaurant\build\libs\Restaurant-0.0.1-SNAPSHOT.jar
timeout 12
start browser http://localhost:8000
pause
docker stop testfront1