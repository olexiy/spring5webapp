node{
  stage ('Preparation') {
        checkout scm
        sh "git rev-parse --short HEAD > .git/commit-id"
        commit_id = readFile('.git/commit-id').trim()
    }

  stage ('Build') {

    withMaven(
        maven: 'mvn',
       // mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {

        sh "mvn clean install"

    }
  }

  stage('SonarQube scan'){
    def sonarqubeScannerHome = tool name: 'sonar', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    withCredentials([string(credentialsId: 'sonar', variable: 'sonarLogin')]){
        sh "${sonarqubeScannerHome}/bin/sonar-scanner -e -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=${sonarLogin} -Dsonar.projectKey=S5W -Dsonar.projectName=spring5webapp -Dsonar.projectVersion='0.0.1-SNAPSHOT' -Dsonar.sources=complete/src/main/ -Dsonar.tests=complete/src/test/ -Dsonar.language=java"
    }
  }

  stage ('docker build/push') {
       docker.withRegistry('https://index.docker.io/v1/', 'dockerhub'){
            def app = docker.build("olexiy/spring5webapp:${commit_id}", '.').push()
       }
  }
}