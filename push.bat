cls
git add .

git commit -m "fix readme"


echo Enviando dados para o bitbucket
git config user.name "Jonas Gama"
git config user.email "jonasgamaifs@gmail.com"

git push git@github.com:jonasgama/spring-kafka-transactional.git
echo "Pronto."
@PAUSE