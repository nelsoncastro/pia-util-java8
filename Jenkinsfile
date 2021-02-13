pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        tool(name: 'maven', type: 'maven3')
        sh 'mvn clean install'
      }
    }

  }
}