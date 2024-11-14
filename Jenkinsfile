pipeline {
    agent any
    environment {
        MYSQL_DATABASE = 'pagamento'   // Variáveis diretamente no Jenkinsfile
        MYSQL_USER = 'root'
        MYSQL_PASSWORD = ''
        DB_PORTS = "3306:3306"
        SERVER_PORTS = "8080:8080"
    }
    stages {
        stage('Verificar Repositório') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], useRemoteConfigs:[[url: 'https://github.com/GuilhermeLBonomo/ProvaMicroservicesSpring.git']]])
            }
        }

        stage('Instalar Dependências e Construir JAR') {
            steps {
                script {
                    // Verifica se é Windows ou Linux e executa o comando adequado
                    if (isUnix()) {
                        sh 'mvn clean install'  // Comando para Linux
                    } else {
                        bat 'mvn clean install'  // Comando para Windows
                    }
                }
            }
        }

        stage('Construir Imagem Docker') {
            steps {
                script {
                    def appName = 'provasmicroservicesjava'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Verifica se é Windows ou Linux e executa o comando adequado para Docker
                    if (isUnix()) {
                        sh "docker build -t ${imageTag} ."  // Para Linux
                    } else {
                        bat "docker build -t ${imageTag} ."  // Para Windows
                    }
                }
            }
        }

        stage('Fazer Deploy') {
            steps {
                script {
                    def appName = 'provasmicroservicesjava'
                    def imageTag = "${appName}:${env.BUILD_ID}"

                    // Verifica se é Windows ou Linux e executa os comandos Docker adequados
                    if (isUnix()) {
                        // Parar e remover o container no Linux
                        sh "docker ps -q -f name=${appName} | xargs -r docker stop"
                        sh "docker ps -a -q -f name=${appName} | xargs -r docker rm"
                        sh "docker run -d --name ${appName} -p 8081:8081 ${imageTag}"
                    } else {
                        // Parar e remover o container no Windows
                        bat "docker ps -q -f name=${appName} | xargs -r docker stop"
                        bat "docker ps -a -q -f name=${appName} | xargs -r docker rm"
                        bat "docker run -d --name ${appName} -p 8081:8081 ${imageTag}"
                    }
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
