pipeline {
    agent any
    
    stages {
        stage('Clone repository') {
            steps {
                git 'https://github.com/Shrira4a/Cours.git'
            }
        }
        
        stage('Build and run Python script with Docker') {
            steps {
                script {
                    docker.image('python:latest').inside {
                        sh 'pip install -r Docker.txt'
                        sh 'app.py'
                    }
                }
            }
        }
    }
}
