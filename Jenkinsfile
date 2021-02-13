pipeline {
  agent any
  stages {
    stage('Buiding') {
      steps {
        echo 'Initiating maven build'
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Testing') {
      parallel {
        stage('SonarQube Test') {
          steps {
            sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.128.4:9000'
          }
        }

        stage('Print Tester Credentials') {
          steps {
            echo "The tester is ${TESTER}"
            sleep 10
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
  tools {
    maven 'maven'
  }
  environment {
    TESTER = 'Nelson'
  }
}