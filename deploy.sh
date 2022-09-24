echo "开始打包"
git checkout master
git pull

declare server=$1
declare port=$2
mvn clean package -Dmaven.test.skip=true


declare targetJar=`ls ./${server}/target/*.jar | grep -v "sources"`
echo "Get File Sucess:${targetJar}"

cp -rf $targetJar ROOT.jar

echo "准备下线服务${server}"
docker stop ${server}
docker rm ${server}
docker rmi ${server}:1.0
echo "${server}已下线"

echo "开始构建镜像${server}"
docker build -t ${server}:1.0 .
echo "镜像构建完成${server}"

echo "开始运行容器${server}"
docker run -d -p ${port}:${port} --name ${server} ${server}:1.0
echo "${server}容器运行成功"