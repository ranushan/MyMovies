pipeline {
    agent any
    post { 
	always { 
            cleanWs()
        }
    }
    stages {
	stage('Sonar Analyse') {
	    steps{
	    	echo 'Analyse'
		sh 'mvn sonar:sonar -Dsonar.projectName=MyMovies -Dsonar.projectKey=key_mymovies -Dsonar.java.binaries="/var/lib/jenkins/workspace/ature_06092019_Architecture_Code/target/sonar" -Dsonar.host.url=http://so.ranushan.com:9000 -Dsonar.login=58932927f3be6b8d0cb8cceb25737b744294b9c3 -Dsonar.branch.name=env.BRANCH_NAME'
	    }
	}
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
	stage('Package') {
            steps {
                echo 'Package..'
		sh 'mvn clean package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
		junit '**/target/surefire-reports/TEST-*.xml'
		archiveArtifacts 'target/*.jar'
            }
        }
    }
}
