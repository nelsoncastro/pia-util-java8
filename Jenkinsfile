pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
    }

  }
  stages {
    stage('Building') {
      steps {
        sh ' mvn -B'
        cleanWs(cleanWhenSuccess: true, cleanWhenAborted: true, cleanWhenFailure: true)
      }
    }

  }
}