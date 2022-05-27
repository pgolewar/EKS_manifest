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
        
	 stage('coit-frontend Build '){
            steps{
                dir('./coit-frontend'){
				echo "path- $PATH"
				script{
				def FRONTENDDOCKER = 'Dockerfile-multistage'
				DockerFrontend = docker.build("coit-frontend:${env.BUILD_TAG}","-f ${FRONTENDDOCKER} .")
				//sh('docker build -t kollidatta/coitfrontend:v1 -f Dockerfile-multistage .')
				}
				} 
            }
        }
				
            
        
		stage('Push Frontend'){
			steps{
				sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
				sh "docker tag coit-frontend:${env.BUILD_TAG} ${REPOSITORY_URI}:${env.BUILD_TAG}"
                sh "docker push ${REPOSITORY_URI}:${env.BUILD_TAG}"

			}
		}


		stage('coit-backend1 Build '){
            steps{
                dir('./coit-backend1'){
				echo "path- $PATH"
				script{
				def backend1 = 'Dockerfile-multistage'
				DockerBackend1 = docker.build("coit-backend1:${env.BUILD_TAG}","-f ${backend1} .")
				//sh('docker build -t kollidatta/coitfrontend:v1 -f Dockerfile-multistage .')
				}
				} 
            }
        }
				
            
        
		stage('Push backend1'){
			steps{
				sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
				sh "docker tag coit-backend1:${env.BUILD_TAG} ${REPOSITORY_URI}:${env.BUILD_TAG}"
                sh "docker push ${REPOSITORY_URI}:${env.BUILD_TAG}"

			}
		}


		stage('backend2 Build '){
            steps{
                dir('./coit-backend2'){
				echo "path- $PATH"
				script{
				def backend2 = 'Dockerfile'
				DockerBackend2 = docker.build("coit-backend2:${env.BUILD_TAG}","-f ${backend2} .")
				//sh('docker build -t kollidatta/coitfrontend:v1 -f Dockerfile-multistage .')
				}
				} 
            }
        }
				
            
        
		stage('Push backend2'){
			steps{
				sh "aws ecr get-login-password --region ${AWS_DEFAULT_REGION} | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_DEFAULT_REGION}.amazonaws.com"
				sh "docker tag coit-backend2:${env.BUILD_TAG} ${REPOSITORY_URI}:${env.BUILD_TAG}"
                sh "docker push ${REPOSITORY_URI}:${env.BUILD_TAG}"

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


