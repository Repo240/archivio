pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'  // deve essere configurato in Jenkins
        jdk 'JDK 21'         // o la versione che usi
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Repo240/archivio.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Build riuscita!'
        }
        failure {
            echo '❌ Build fallita.'
        }
    }
}
