pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKERFILE_PATH = "Dockerfile" // Path to Dockerfile in GitHub repository
        DOCKER_REPO = "newdocker" // Docker repository name
        DOCKER_TAG = "final" // Docker image tag
        DOCKER_HUB_USERNAME = credentials('git_credentials')
        DOCKER_HUB_PASSWORD = credentials('git_credentials')
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
                    sh "docker login -u ${DOCKER_HUB_USERNAME} -p ${DOCKER_HUB_PASSWORD}"
                    sh "docker tag <local_image_name>:${DOCKER_TAG} ${DOCKER_HUB_USERNAME}/${DOCKER_REPO}:${DOCKER_TAG}"
                    sh "docker push ${DOCKER_HUB_USERNAME}/${DOCKER_REPO}:${DOCKER_TAG}"
                    }
                }
            }
        }
    }
}
