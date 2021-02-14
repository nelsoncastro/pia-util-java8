pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        sh 'mvn clean install -DskipTests'
      }
    }
    stage('Quality Gate') {
      steps {
        withSonarQubeEnv('default') {
          sh 'mvn sonar:sonar'
        }
        timeout(time: 5, unit: 'MINUTES') {
          waitForQualityGate true
        }
      }
    }
  }
}
