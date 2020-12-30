void call(){
   stage('static code analysis') {    
      node { //if you open a second node block it will be in a different workspace with an @2 
         //this workspace assumes that the buid step was done on the same node agent. perhaps better to make it parameterized
         //or use stash unstash. but that might hinder performance
         String sonarKey = config.containsKey("sast_project_key")?config.sast_project_key:""
         String sonarTokenID = config.containsKey("sast_project_token")?config.sast_project_token:""
         String sonarOrganization = config.containsKey("sast_project_organization")?config.sast_project_organization:""
         String sonarURL = config.containsKey("sast_project_url")?config.sast_project_url:"https://sonarcloud.io"
         println("sonarqube: static_code_analysis() for ${sonarKey}")

         withCredentials([string(credentialsId: 'sonarcloud-key', variable: 'sonarToken')]) {
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
