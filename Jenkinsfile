pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKERFILE_PATH = "Dockerfile" // Path to Dockerfile in GitHub repository
        DOCKER_REPO = "newdocker" // Docker repository name
        DOCKER_TAG = "final" // Docker image tag
    }

    stages {
        stage('Clone repository') {
            steps {
                // Clone GitHub repository
                git branch: 'main', url: 'https://github.com/Shrira4a/Cours.git'
            }
        }

        stage('Build Docker image') {
            steps {
                // Build Docker image
                script {
                    docker.build("${DOCKER_REPO}:${DOCKER_TAG}", "-f ${DOCKERFILE_PATH} .")
                }
            }
        }

        stage('Push Docker image') {
            steps {
                // Push Docker image to repository
                script { 
                     withDockerRegistry([ credentialsId: "git_credentials", url: "" ]){
                        sh 'sudo docker push ${DOCKER_REPO}:${DOCKER_TAG}'
                    }
                }
            }
        }
    }
}
