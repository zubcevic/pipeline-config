void call(){
    stage('build - maven') {
	    println "maven: build()"
        checkout scm
        //withEnv(["JAVA_HOME=${tool 'JDK8'}","PATH=${tool 'JDK8'}/bin:${tool 'MAVEN35'}/bin:$PATH"]) {
        //sh 'mvn clean install'
        //}

    }
}
