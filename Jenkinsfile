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

  stage ('docker build/push') {
       docker.withRegistry('https://index.docker.io/v1/', 'dockerhub'){
            def app = docker.build("olexiy/spring5webapp:${commit_id}", '.').push()
       }
  }
}