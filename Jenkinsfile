pipeline {
    agent any
    tools {
        maven 'maven 3.5.3'
        jdk 'jdk8'
    }
    stages {
        stage ('Initialize') {
            git 'https://github.com/olexiy/spring5webapp.git'
            steps {
                env.JAVA_HOME="${tool 'jdk8'}"
                env.PATH="${env.JAVA_HOME}/bin:${env.PATH}"
                sh 'java -version'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}