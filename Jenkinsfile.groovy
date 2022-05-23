
#!/usr/bin/env groovy

// Jenkinsfile (Declarative Pipeline)
pipeline {
  agent any
  stages {
    stage('Stage 1') {
      steps {
        echo 'Hello world!_1st commit'
        sh cd /.jenkin
      }
    }
  }
}
