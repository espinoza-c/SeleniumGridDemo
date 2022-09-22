pipeline{
  agent any
  stages{
    stage('Run Test') {
      parallel {
        stage('End to end tests'){
          steps{
            bat "mvn test"
          }
        }
        stage('End to end tests'){
          steps{
            bat "echo tests completed successfully"
          }
        }
      }
    }
  }
}
