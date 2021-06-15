pipeline {
  agent any
  stages {
    stage('Sonarqube Analyses') {
      steps {
        withSonarQubeEnv('default') {
          sh 'mvn clean verify sonar:sonar'
        }
      }
    }
    stage('Quality Gate') {
      steps {
        waitForQualityGate true
      }
    }
  }
}
