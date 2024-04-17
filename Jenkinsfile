pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKERFILE_PATH = "Dockerfile" // Path to Dockerfile in GitHub repository
        DOCKER_IMAGE_NAME='shrira4a/newdocker'
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
                   docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_TAG}", "-f ${DOCKERFILE_PATH} .")
                }
            }
        }

        stage('Save artifacts') {
            steps {
                // Save Dockerfile as an artifact
                archiveArtifacts artifacts: 'Dockerfile', onlyIfSuccessful: false
                
                // Save Docker image as an artifact
                archiveArtifacts artifacts: '*.tar', onlyIfSuccessful: false
            }
        }

        stage('Push Docker image') {
            steps {
                // Push Docker image to repository
                script { 
                    docker.withRegistry('https://index.docker.io/v1/', 'git_credentials') {
                     docker.image("${DOCKER_IMAGE_NAME}:${DOCKER_TAG}").push()
            }
        }
    }
}
        stage('Run Docker image') {
            steps {
                // Run Docker image
                script {
                    docker.image("${DOCKER_IMAGE_NAME}:${DOCKER_TAG}").run('-d -p 81:80')
                }
            }
        }
        
    }
}

