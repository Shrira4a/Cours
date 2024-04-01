pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Shrira4a/Cours.git']]])
            }
        }
        stage('Build') {
            steps {
                git branch: 'main', url: 'https://github.com/Shrira4a/Cours.git'
                sudo sh 'python3 app.py'
            }
        }
        stage('Test') {
            steps {
                sudo sh 'python3 -m pytest'
            }
        }
    }
}
