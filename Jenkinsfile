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
          sh 'mvn sonar:sonar'
        }

      }
    }

    stage('Quality Gate Result') {
      steps {
        waitForQualityGate true
      }
    }

  }
}