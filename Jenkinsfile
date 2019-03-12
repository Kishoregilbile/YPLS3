pipeline 
{
	agent any
	stages
	{
		stage ('GIT Checkout Stage')
		{
			steps
			{
					checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Kishoregilbile/YPLS3.git']]])
			}
		}
		
		stage ('Testing Stage')
		{
			steps
			{
				withMaven(maven: 'LMSMaven')
					 {
   				 		bat 'mvn clean install' //-Dcucumber.options=\"--tags @asset\"'
				 	}
			}
		}
		
		stage ('HTML Reports')
		{
			steps
			{
				publishHTML([allowMissing: false, 
									alwaysLinkToLastBuild: false, 
									keepAll: false, 
									reportDir: '/YPLS/output', 
									reportFiles: 'YPLSReport.html', 
									reportName: 'YPLS HTML Report', 
									reportTitles: ''])	
			}
	}
}