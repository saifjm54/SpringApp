pipeline {
    agent any
    stages {
        stage('Commit Stage') {
            steps {
                echo 'Starting Commit Stage...'
                // Checkout code
                checkout scm

                // Compile code
                sh 'mvn compile'

                // Run unit tests
                sh 'mvn test'

                // Package application
                sh 'mvn package'
            }
        }
        stage('Acceptance Tests Stage') {
            steps {
                echo 'Starting Acceptance Tests Stage...'
                // Build Docker image
                sh 'docker build -t spring-ci-example .'

                // Run application container
                sh 'docker run -d -p 8080:8080 --name spring-app spring-ci-example'

                // Run acceptance tests
                sh 'mvn -f test-acceptance/pom.xml test'
            }
            post {
                always {
                    // Cleanup Docker containers
                    sh 'docker stop spring-app || true && docker rm spring-app || true'
                }
            }
        }
    }
    post {
        success {
            echo 'Build and Tests Successful!'
        }
        failure {
            echo 'Build or Tests Failed!'
        }
    }
}