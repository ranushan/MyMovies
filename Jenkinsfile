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
		sh 'mvn sonar:sonar -Dsonar.projectName=MyMovies -Dsonar.projectKey=key_mymovies -Dsonar.sources=directory\src\ -Dsonar.java.binaries=.build\libs\ -Dsonar.host.url=http://82.253.39.25:9000 -Dsonar.login=a6069755f342d810ad058635e886612048fdea4a'
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
