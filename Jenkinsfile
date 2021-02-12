pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v ./.m2:/root/.m2'
    }

  }
  stages {
    stage('build') {
      steps {
        echo 'Starting Build Step'
        sh 'mvn -B -DskipTests clean package'
        echo 'Build Step Completed'
      }
    }

  }
}