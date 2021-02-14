pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
    stage('Sonarqube Analyses') {
      steps {
        withSonarQubeEnv('default') {
          sh 'mvn sonar:sonar'
        }
      }
    }
    stage('Quality Gate') {
      steps {
        timeout(time: 5, unit: 'MINUTES') {
          waitForQualityGate true
        }
      }
    }
  }
}
