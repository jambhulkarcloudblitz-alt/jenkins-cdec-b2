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
        // stage ('TEST') {
        //     steps {
        //         sh '''cd backend
        //             mvn  sonar:sonar \\
        //             -Dsonar.projectKey=studentapp \\
        //             -Dsonar.projectName=\'studentapp\' \\
        //             -Dsonar.host.url=http://54.177.15.249:9000 \\
        //             -Dsonar.token=sqp_254f1898b4e2e7021939a84acaa1bffed1b71d37
        //             '''
        //     }
        // }
        stage ('TEST') {
            steps {
                withSonarQubeEnv(installationName: 'sonarqube', credentialsId: 'sonar-cred') {
                   sh '''cd backend
                   mvn sonar:sonar  -Dsonar.projectKey=studentapp
                   '''
            }
        }
        }
        stage ('QUALITY-GATE') {
            steps {
                timeout(10) {
                    waitForQualityGate abortPipeline: true , credentialsId: 'sonar-cred'
                    }
            }
        }
        stage ('S3-UPLOAD') {
            steps {
                echo "tets"
            }
        }
    }
}