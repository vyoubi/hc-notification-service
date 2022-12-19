pipeline {
    agent any
    tools {
        maven 'MAVEN-3.8.4'
    }
    environment {
        DOCKER_TAG = "${BUILD_NUMBER}"
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/vyoubi/hc-notification-service']]])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image') {
            steps {
                sh 'docker version'
                sh 'docker build -t hc-notification-service .'
                sh 'docker image list'
                sh 'docker tag hc-notification-service valere1991/hc-notification-service:${DOCKER_TAG}'
            }
        }
        stage('Docker Hub login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Dockerhub-Val', passwordVariable: 'password', usernameVariable: 'username')]) {
                sh 'docker login -u $username -p $password'
                }
            }
        }
        stage('Push image to Docker Hub') {
            steps {
                sh 'docker push valere1991/hc-notification-service:${DOCKER_TAG}'
            }
        }
        stage("remove unused docker image"){
            steps{
            sh 'docker rmi hc-notification-service -f'
            sh 'docker rmi valere1991/hc-notification-service:${DOCKER_TAG} -f'
         }
        }
    }
}
