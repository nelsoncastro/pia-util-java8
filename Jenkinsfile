pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        echo 'Initiating maven build'
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Testing') {
      parallel {
        stage('SonarQube Test') {
          steps {
            sh "mvn sonar:sonar -Dsonar.host.url=${SONAR_SERVER_URL}"
          }
        }

        stage('Print build number') {
          steps {
            echo "This is build number ${BUILD_ID}"
            sleep 20
          }
        }

      }
    }

  }
  environment {
    SONAR_SERVER_URL = 'http://192.168.128.4:9000'
  }
}