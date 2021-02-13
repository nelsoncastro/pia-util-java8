pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /Users/nelson/.m2:/root/.m2'
    }

  }
  stages {
    stage('Building') {
      steps {
        sh ' mvn clean install'
        cleanWs(cleanWhenAborted: true, cleanWhenFailure: true, cleanWhenNotBuilt: true, cleanWhenSuccess: true, cleanWhenUnstable: true, cleanupMatrixParent: true)
      }
    }

  }
}