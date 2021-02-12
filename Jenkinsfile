pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        echo 'Starting Build Step'
        sh 'mvn clean install -Dlicense.skip=true'
        echo 'Build Step Completed'
      }
    }

  }
}