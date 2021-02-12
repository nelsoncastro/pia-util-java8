pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/.m2:/root/.m2'
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