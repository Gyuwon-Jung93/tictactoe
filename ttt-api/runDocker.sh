echo "******Running ttt-api server******"


docker build --tag ttt/gameapi .

docker run -it -p 8083:8083 -d ttt/gameapi