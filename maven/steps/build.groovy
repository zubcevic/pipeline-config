void call(){
    stage('build - maven') {
	    println "maven: build()"
        buildDiscarder logRotator(artifactDaysToKeepStr: '30', artifactNumToKeepStr: '5', daysToKeepStr: '30', numToKeepStr: '5')
        
        node {
        if (!isUnix()) {
            println("not a unix os")
        } else {
            println("a unix based os")
            checkout scm // ONLY for multi branch or pipeline from SCM

            withEnv(["JAVA_HOME=${tool 'JDK11'}","PATH=${tool 'JDK11'}/bin:${tool 'MAVEN363'}/bin:$PATH"]) {
                sh 'mvn clean compile'
            }
        }
        }

    }
}
