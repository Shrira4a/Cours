pipeline {
    agent any

    environment {
        // Define environment variables
        DOCKERFILE_PATH = "Dockerfile" // Path to Dockerfile in GitHub repository
        DOCKER_REPO = "newdocker" // Docker repository name
        DOCKER_TAG = "final" // Docker image tag
        DOCKER_HUB_USERNAME = ''
        DOCKER_HUB_USERNAME_CRED = credentials('git_credentials')
        DOCKER_HUB_PASSWORD_CRED = credentials('git_credentials')
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
                   withCredentials([usernamePassword(credentialsId: DOCKER_HUB_USERNAME_CRED, passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                        // Create a temporary file to store the Docker Hub password
                        def passwordFile = sh(script: 'mktemp', returnStdout: true).trim()
                    
                        // Write the Docker Hub password to the temporary file
                        writeFile file: passwordFile, text: "${DOCKER_HUB_PASSWORD}"
                    
                        // Login to Docker Hub using --password-stdin
                        sh "cat ${passwordFile} | docker login -u ${DOCKER_HUB_USERNAME} --password-stdin"
                    
                        // Remove the temporary file
                        sh "rm -f ${passwordFile}"
                    
                        // Tag and push the Docker image
                        sh "docker tag <local_image_name>:${DOCKER_TAG} ${DOCKER_HUB_USERNAME}/${DOCKER_REPO}:${DOCKER_TAG}"
                        sh "docker push ${DOCKER_HUB_USERNAME}/${DOCKER_REPOSITORY}:${DOCKER_TAG}"
            }
        }
    }
}
    }
}
