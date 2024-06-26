pipeline{

    agent any
    tools{
        maven "maven"
    }
    environment{
           APP_NAME = "spring-docker-cicd"
           RELEASE_NO= "1.0.0"
           DOCKER_USER= "praveen990"
           IMAGE_NAME= "${DOCKER_USER}"+"/"+"${APP_NAME}"
           IMAGE_TAG= "${RELEASE_NO}-${BUILD_NUMBER}"
    }
    stages{

        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/praveen9900/jenkins-cicd.git']])
            }
        }

        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }

        stage("Build Image"){
            steps{
                script{
                    bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage("Deploy Image to Hub"){
            steps{
               withCredentials([string(credentialsId: 'token', variable: 'token')]) {
                    bat "docker login -u praveen990 -p %token%"
                    bat "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }

    }

    post{
        always{
            emailext attachLog: true,
            body: ''' <html>
    <body>
        <p>Build Status: ${BUILD_STATUS}</p>
        <p>Build Number: ${BUILD_NUMBER}</p>
        <p>Check the <a href="${BUILD_URL}">console output</a>.</p>
    </body>
</html>''', mimeType: 'text/html', replyTo: 'omsairam4666@gmail.com', subject: 'Pipeline Status : ${BUILD_NUMBER}', to: 'omsairam4666@gmail.com'

        }
    }
}
