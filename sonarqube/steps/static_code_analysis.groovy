void call(){
   stage('static code analysis') {    
      node {
         String sonarKey = config.containsKey("sast_project_key")?config.sast_project_key:""
         String sonarToken = config.containsKey("sast_project_token")?config.sast_project_token:""
         String sonarOrganization = config.containsKey("sast_project_organization")?config.sast_project_organization:""
         String sonarURL = config.containsKey("sast_project_url")?config.sast_project_url:"https://sonarcloud.io"
         println("sonarqube: static_code_analysis() for ${sonarKey}")
         node {
            withEnv([
               "JAVA_HOME=${tool 'JDK11'}",
               "PATH=${tool 'JDK11'}/bin:${tool 'MAVEN363'}/bin:$PATH",
               "SONAR_TOKEN=${sonarToken}"]) {
                sh "mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=${sonarKey} -Dsonar.organization=${sonarOrganization} -Dsonar.host.url=${sonarURL}"
            }
         }
      }
   }
}
