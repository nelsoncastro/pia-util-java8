pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'Starting Build Step'
        sh 'mvn clean install -DskipTests'
        echo 'Build Step Completed'
      }
    }

  }
}