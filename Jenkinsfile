pipeline{
  agent any
  stages{
    stage('Run Test') {
      parallel {
        stage('Unit test'){
          steps{
            bat "mvn test"
          }
        }
      }
    }
  }
}
