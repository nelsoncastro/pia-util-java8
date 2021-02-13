pipeline {
  agent any
  stages {
    stage('Building') {
      steps {
        echo 'Initiating maven build'
        sh 'mvn clean install -DskipTests'
      }
    }

    stage('Quality Gate') {
      steps {
        withSonarQubeEnv('default') {
          sh 'mvn sonar:sonar -Dsonar.webhooks.project=http://192.168.144.2/sonarqube-webhook'
        }

        timeout(time: 5, unit: 'MINUTES') {
          waitForQualityGate true
        }

      }
    }

  }
}