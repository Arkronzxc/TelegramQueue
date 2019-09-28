@echo off
set /p message=Write commit message 

IF %message%=="" (
 ECHO Empty commit message
 EXIT 1
)

START cmd.exe /k heroku logs --tail

git add *
git commit -m %message%
git push origin master
git push heroku master
heroku ps:scale worker=1

