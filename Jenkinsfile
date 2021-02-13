pipeline {
  agent any
  stages {
    stage('Buiding') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }

  }
}