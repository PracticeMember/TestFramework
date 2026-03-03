pipeline{
    agent any
    stages{    
        stage('Checkout'){
            steps{
                git branch: 'master' ,
                url: 'https://github.com/PracticeMember/TestFramework.git'  
            }
        }
		stage('Build and test'){
		    steps{   
		        sh 'mvn clean test -Dbrowser=chrome'
		    }
		}

    }

}
