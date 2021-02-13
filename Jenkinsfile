pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        sh 'mvn --version'
      }
    }

    stage('Build') {
      steps {
        echo 'This is a minimal pipeline.'
      }
    }

  }
  tools {
    maven 'maven3'
  }
}