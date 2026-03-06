pipeline{
    agent any
    
    stages{
        stage('Checkout'){
        steps{
             git branch: 'master',
             url: 'https://github.com/PracticeMember/TestFramework.git'
            }
        }
		stage('Build and Test in Parallel'){
		    parallel{
		        stage('Chrome Tests'){
		        steps{
		            bat 'mvn clean test -Dbrowser=chrome'
		        }
		        }
		        stage('Firefox Tests'){
		         steps{
		             bat 'mvn clean test -Dbrowser=firefox'
		          }
		        }

		        }
		}

    }
		post{
   			  always{
		        junit '**/target/surefire-reports/*.xml'
		        archiveArtifacts artifacts: 'test-reports/**',
		        allowEmptyArchive: true
		    }

		}
}
