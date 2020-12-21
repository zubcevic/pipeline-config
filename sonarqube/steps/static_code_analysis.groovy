void call(){
   stage('static code analysis') {    
      node {
         String sonarKey = config.containsKey("sast_project_key")?config.sast_project_key:""
         println("sonarqube: static_code_analysis() for ${sonarKey}")
      }
   }
}
