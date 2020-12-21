void call(){
    stage('maven: unit test') {
        println "maven: unit_test()"
        node {
        if (!isUnix()) {
            println("not a unix os")
        } else {
            println("a unix based os")
            withEnv(["JAVA_HOME=${tool 'JDK11'}","PATH=${tool 'JDK11'}/bin:${tool 'MAVEN363'}/bin:$PATH"]) {
                sh 'mvn test'
            }
        }
        }
    }
}
