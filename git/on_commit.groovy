void call(Map args = [:], body){

  println "running because of $env.GIT_BUILD_CAUSE to ${args.to} $env.BRANCH_NAME "
  
  def branch = env.BRANCH_NAME
    
  // do nothing if branch doesn't match regex
  if (args.to)
  if (!(branch ==~ args.to))
    return
  
  println "running because of a commit to ${branch}"
  body()
  
}
