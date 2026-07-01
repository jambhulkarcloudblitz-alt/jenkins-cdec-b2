pipeline {
    agent any 
    stages {
        stage ('PULL') {
            steps {
                git branch: 'devops', url: 'https://github.com/jambhulkarcloudblitz-alt/CDEC-studentapp.git'
            }
        }
        stage ('BUILD') {
            steps {
                sh '''cd backend
                    mvn clean package -DskipTests'''
            }
        }
        stage ('TEST') {
            steps {
                echo "tets"
            }
        }
        stage ('QUALITY-GATE') {
            steps {
                echo "tets"
            }
        }
        stage ('S3-UPLOAD') {
            steps {
                echo "tets"
            }
        }
    }
}