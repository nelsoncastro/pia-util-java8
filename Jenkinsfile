pipeline {
  agent {
    docker {
      image 'docker'
    }

  }
  stages {
    stage('build') {
      steps {
        echo 'Starting Build Step'
        sh 'docker run hello-world'
        echo 'Build Step Completed'
      }
    }

  }
}