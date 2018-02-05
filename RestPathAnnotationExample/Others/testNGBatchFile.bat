set projectLocation=C:\Eclipse_Workspace\Cer_SampleProject
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\jars\*
java org.testng.TestNG %projectLocation%\testng.xml
pause