pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
        echo '${M2_HOME}'
      }
    }

  }
  environment {
    M2_HOME = '/var/jenkins_home/downloads/apache-maven-3.6.3'
  }
}