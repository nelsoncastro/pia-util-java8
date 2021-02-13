pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /Users/nelson/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
        cleanWs()
      }
    }

    stage('Quality Gate') {
      steps {
        sh 'mvn sonar:sonar'
      }
    }

  }
}