pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Quality Gate') {
      steps {
        sh 'mvn sonar:sonar'
      }
    }

  }
}