pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
    stage('Sonarqube Analyses') {
      steps {
        withSonarQubeEnv('default') {
          sh 'mvn sonar:sonar'
        }
      }
    }
    stage('Quality Gate') {
      steps {
        waitForQualityGate true
      }
    }
    stage('Release') {
      steps {
        sh 'mvn release:prepare'
      }
    }
  }
}
