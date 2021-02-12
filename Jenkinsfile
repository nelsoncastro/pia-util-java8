pipeline {
  agent {
    docker {
      args '-p 3000:3000'
      image 'maven:3.6.3-openjdk-8'
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