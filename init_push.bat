cd /d "%~dp0"
git init
git add *
git commit -a -m "version initiale"
git remote add al30_orchestrationJava https://didier-tp:....!@github.com/didier-tp/al30_orchestrationJava.git
git push -u al30_orchestrationJava master
pause

REM open with text editor
REM opne with system editor