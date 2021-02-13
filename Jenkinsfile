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
  environment {
    M2_HOME = '/Users/nelson/apache-maven-3.6.1'
  }
}