pipeline {
    agent any
     //tools {
     //       maven 'Maven 3.9.2'
     //       jdk 'OpenJDK 17'
     //   }
     stages {
            stage('Verificar Repositório') {
                steps {
                    checkout([$class: 'GitSCM', branches: [[name: '*/main']], useRemoteConfigs:[[url: 'https://github.com/GuilhermeLBonomo/ProvaMicroservicesSpring.git']]])
                }
            }

            stage('Instalar Dependências e Construir JAR') {
                        steps {
                            script {
                                sh 'mvn clean install'  // powershell 'mvn clean install'
                            }
                        }
                    }
            stage('Construir Imagem Docker') {
                        steps {
                            script {
                                def appName = 'provasmicroservicesjava'
                                def imageTag = "${appName}:${env.BUILD_ID}"

                                // Construir a imagem Docker
                                bat "docker build -t ${imageTag} ."
                            }
                        }
                    }
             stage('Fazer Deploy') {
                        steps {
                            script {
                                def appName = 'provasmicroservicesjava'
                                def imageTag = "${appName}:${env.BUILD_ID}"
                                // Parar e remover o container existente, se houver
                                sh "docker stop ${appName} || true"
                                sh "docker rm ${appName} || true"
                                // Executar o novo containerssss
                                sh "docker run -d --name ${appName} -p 3000:3000 ${imageTag}"
                            }
                        }
                    }
                }
                post {
                    success {
                        echo 'Deploy realizado com sucesso!'
                    }
                    failure {
                        echo 'Houve um erro durante o deploy.'
                    }
        }
}