@echo off
cd .\target\
:ask
@echo Doriti sa folositi interfata grafica? (Y/N)
set INPUT=
set /P INPUT=: %=%
If /I "%INPUT%"=="y" goto yes 
If /I "%INPUT%"=="n" goto no
goto ask
:yes
java -jar .\Exchange-1.0-SNAPSHOT-jar-with-dependencies.jar 
goto exit
:no
java -jar .\Exchange-1.0-SNAPSHOT-jar-with-dependencies.jar "no_gui"
goto exit
:exit
@pause