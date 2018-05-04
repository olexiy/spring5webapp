node{
  stage ('Build') {

    git url: 'https://github.com/olexiy/spring5webapp.git'

    withMaven(
        maven: 'maven 3.5.3',
       // mavenSettingsConfig: 'my-maven-settings',
        mavenLocalRepo: '.repository') {

      sh "mvn clean install"

    }
  }
}