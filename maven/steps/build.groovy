void call(){
    stage('build - maven') {
	    println "maven: build()"
        buildDiscarder logRotator(artifactDaysToKeepStr: '30', artifactNumToKeepStr: '5', daysToKeepStr: '30', numToKeepStr: '5')
//checkout scm // ONLY for multi branch or pipeline from SCM
        //withEnv(["JAVA_HOME=${tool 'JDK8'}","PATH=${tool 'JDK8'}/bin:${tool 'MAVEN35'}/bin:$PATH"]) {
        //sh 'mvn clean install'
        //}
        node {
        if (!isUnix()) {
            println("not a unix os")
        } else {
            println("a unix based os")
        }
        }

    }
}
