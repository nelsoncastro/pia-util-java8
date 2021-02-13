pipeline {
  agent any
  
  environment {
    M2_HOME = '/var/jenkins_home/downloads/apache-maven-3.6.3'
    }  
  
  stages {
    stage('Build') {
      steps {
        echo "${M2_HOME}"
        sh 'printenv'
      }
    }

  }
}
