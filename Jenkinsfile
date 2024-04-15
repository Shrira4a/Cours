pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKERFILE_PATH = "Dockerfile" // Path to Dockerfile in GitHub repository
        DOCKER_REPO = "newdocker" // Docker repository name
        DOCKER_TAG = "final" // Docker image tag
        DOCKER_HUB_USERNAME_CREDENTIAL = credentials('git_credentials')
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
                    withCredentials([usernamePassword(credentialsId: DOCKER_HUB_USERNAME_CREDENTIAL, passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                        docker.withRegistry('https://index.docker.io/v1/', 'git_credentials') {
                            docker.image("your-docker-image:${DOCKER_TAG}").push("${DOCKER_REPO}:${DOCKER_TAG}")
            }
        }
    }
}
    }
}
