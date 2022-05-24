pipeline{
    agent any
    environment {
        AWS_ACCOUNT_ID="273488666711"
        AWS_DEFAULT_REGION="us-east-1" 
        IMAGE_REPO_NAME="coit_repository"
        IMAGE_TAG="latest"
        REPOSITORY_URI = "${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com/${IMAGE_REPO_NAME}"
                 }
	stages{
		stage('Checkout'){
			steps{
				sh 'mvn --version'
				sh 'docker --version'
				echo "Build"
				echo "PATH - $PATH"
				echo "BUILD_NUMBER - $env.BUILD_NUMBER"
				echo "BUILD_ID - $env.BUILD_ID"
				echo "BUILD_TAG - $env.BUILD_TAG"
				echo "JOB_NAME - $env.JOB_NAME"
			}
		}
        
	stage('Checkout code') {
        steps {
            checkout scm
             }
         }
				
            
        
		stage('Push Frontend'){
			steps{
				echo "Push"

			}
		}
		
    }
	post {
			always{
				echo "Im awesome. I run always"
			}
			success{
				echo 'I run when you are successful'
			}
			failure{
				echo 'I run when you fail'
			}
		}
	

}

