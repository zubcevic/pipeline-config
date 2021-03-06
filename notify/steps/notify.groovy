import hudson.tasks.Mailer;
import hudson.model.User;
import hudson.model.Cause;
import hudson.model.Cause.UserIdCause;

@BeforeStep({ hookContext.step.equals("build") })
void callBefore(){
    def cause = currentBuild.rawBuild.getCause(hudson.model.Cause$UserIdCause)
    def id = cause.getUserId()
    User u = User.get(id)
    def umail = u.getProperty(Mailer.UserProperty.class)
    
    println("build step started by: ${umail.getAddress()}")
}

@AfterStep({ hookContext.step.equals("build") })
void callAfter(){
    /*
        execute something right before the library step called
        build is executed.
    */
    println("build step finished: ${currentBuild.currentResult}")

try {
    def cause = currentBuild.rawBuild.getCause(hudson.model.Cause$UserIdCause)
    def id = cause.getUserId()
    User u = User.get(id)
    def umail = u.getProperty(Mailer.UserProperty.class)

    mail body:"Build result ${currentBuild.currentResult}",subject:"Build result ${currentBuild.currentResult}",to:"${umail.getAddress()}"
} catch (e) {
	echo e.getMessage()
}
}
