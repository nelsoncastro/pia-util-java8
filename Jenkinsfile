pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /Users/nelson/.m2:/root/.m2'
    }

  }
  stages {
    stage('Release') {
      steps {
        sh 'mvn git-release:execute'
        cleanWs()
      }
    }

  }
}