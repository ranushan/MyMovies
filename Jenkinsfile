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
		sh 'mvn sonar:sonar -Dsonar.projectName=MyMovies -Dsonar.projectKey=key_mymovies -Dsonar.java.binaries=**/target/classes -Dsonar.host.url=http://82.253.39.25:9000 -Dsonar.login=c7ae943dd0016e9490cdef88289e33ac4a3b24ee'
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
