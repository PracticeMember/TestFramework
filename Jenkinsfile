pipeline{
    agent any
    
    parameters{
        
        choice(
         name: 'BROWSER',
         choices: [ 'chrome','firefox'],
         description: 'Select browser to run tests'
    )
	}
	
    stages{    
        stage('Checkout'){
            steps{
                git branch: 'master' ,
                url: 'https://github.com/PracticeMember/TestFramework.git'  
            }
        }
		stage('Build and test'){
		    steps{   
		        bat 'mvn clean test -Dbrowser=${params.BROWSER}'
		    }
		}

    }

	post{ 
	    always{
	        junit '**/target/surefire-reports/*.xml'
	        publishHTML([
	        	reportDir: 'test-reports',
	        	reportFiles: 'ExtentReporter.html',
	        	reportName:'ExtentReport',
	        	keepAll: true
	         ])
	        archiveArtifacts artifacts: 'test-reports/**',
	        allowEmptyArchive: true
	    }
	}

}
