#install the application
deployEAR="C:/Dev/GitRepos/Study/was-demo/src/main/resources/ear/HRListerEAR.ear"
appName="HRListerEAR"
attr="-appname " + appName + " "
AdminApp.install(deployEAR, "["+attr+"]" );
#save
AdminConfig.save();