pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/Shrira4a/Cours.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'pip install -r Dockerfile.txt' // Install any required dependencies
                sh 'python app.py' // Build your Python script
            }
        }
    }
}
