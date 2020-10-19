void call(app_env){
    stage("deploy - ${app_env.short_name}") {
	println "deploy: deploy_to ${app_env.short_name}"
    }
}
