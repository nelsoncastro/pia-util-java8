pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /Users/nelson/.m2:/usr/share/maven'
    }

  }
  stages {
    stage('Building') {
      steps {
        sh ' mvn --version'
        cleanWs(cleanWhenSuccess: true, cleanWhenAborted: true, cleanWhenFailure: true)
      }
    }

  }
}