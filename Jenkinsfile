pipeline {
    agent any

    tools {
        nodejs "nodejs:14.17.6"
    }

    stages {
        stage('npm install') {
            steps {
                dir('./FE/test') {
                    sh 'npm install'
                }
            }
        }
        stage('npm build') {
            steps {
                dir('./FE/test') {
                    sh 'npm run build'
                }
            }
        }
        stage('build nginx image') {
            steps {
                sh 'docker build -t test/nginx ./FE/ibg'
            }
        }
        stage('nginx deploy') {
            steps {
                // sh 'docker stop test_nginx'
                // sh 'docker rm test_nginx'
                sh 'docker rm test_nginx'
                sh 'docker run --network test -d --name test_nginx -p 80:80 -p 443:443 -v /etc/letsencrypt:/etc/letsencrypt -u root test/nginx'
            }
        }
        stage('build springboot') {
            steps {
                dir('./BE') {
                    sh './gradlew build'
                }
            }
        }
        stage('build springboot image') {
            steps {
                sh 'docker build -t test/springboot ./BE'
            }
        }
        stage('springboot deploy') {
            steps {
                // sh 'docker stop test_springboot'
                // sh 'docker rm test_springboot'
                sh 'docker run --network test -d --name test_springboot -p 7777:7777 -u root test/springboot'
            }
        }
        stage('finish') {
            steps {
                sh 'docker restart test/nginx'
                sh 'docker images -qf dangling=true | xargs -I{} docker rmi {}'
            }
        }
    }
}