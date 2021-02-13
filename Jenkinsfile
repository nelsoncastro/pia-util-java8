pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo "${M2_HOME}"
        sh 'printenv'
        sh "${M2_HOME}"/bin/mvn clean install
        
      }
    }

  }
  environment {
    M2_HOME = '/var/jenkins_home/downloads/apache-maven-3.6.3'
  }
}
