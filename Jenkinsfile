pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        echo 'Initiating maven build'
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('SonarQube analysis') {
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