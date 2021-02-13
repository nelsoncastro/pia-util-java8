pipeline {
  agent any
  stages {
    stage('Buiding') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Testing') {
      parallel {
        stage('Quality Gate') {
          steps {
            sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.128.4:9000'
          }
        }

        stage('Print Tester Credentials') {
          steps {
            echo 'The tester is ${TESTER}'
            sleep 10
          }
        }

      }
    }

  }
}