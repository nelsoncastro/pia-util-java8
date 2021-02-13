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
        timeout(time: 5, unit: 'MINUTES', activity: true) {
          sh '''def qg = waitForQualityGate()
if (qg.status != \'OK\') {
  error "Pipeline aborted due to quality gate failure: ${qg.status}"
}'''
        }

      }
    }

  }
}