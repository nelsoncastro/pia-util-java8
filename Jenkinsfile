pipeline {
  agent {
    docker {
      image 'maven:3.6.3-openjdk-8'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('build') {
      steps {
        echo 'Starting Build Step'
        sh 'mvn clean install -Dlicense.skip=true'
        echo 'Build Step Completed'
      }
    }

  }
}