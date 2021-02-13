pipeline {
  agent any
  stages {
    stage('Buiding') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Testing') {
      steps {
        sh 'mvn sonar:sonar -Dsonar.host.url=http://192.168.128.4:9000'
      }
    }

  }
}