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

            }
        }
        stage ('TEST') {
            steps {

            }
        }
        stage ('QUALITY-GATE') {
            steps {

            }
        }
        stage ('S3-UPLOAD') {
            steps {

            }
        }
    }
}