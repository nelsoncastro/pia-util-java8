pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }

  }
  stages {
    stage('Building') {
      steps {
        sh ' mvn clean package'
      }
    }

  }
}