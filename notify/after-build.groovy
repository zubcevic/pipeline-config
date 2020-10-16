import hudson.tasks.Mailer;
import hudson.model.User;
import hudson.model.Cause;
import hudson.model.Cause.UserIdCause;

@AfterStep({ context.step.equals("build") })
void call(context){
    /*
        execute something right before the library step called
        build is executed.
    */
    println("build step finished: ${currentBuild.currentResult}")

try {
    def cause = currentBuild.getCause(hudson.model.Cause$UserIdCause)
    def id = cause.getUserId()
    User u = User.get(id)
    def umail = u.getProperty(Mailer.UserProperty.class)
    print umail.getAddress()
} catch (e) {}

    mail bcc:'',body:'Test',cc:'',from:'',replyTo:'',subject:"Build result ${currentBuild.currentResult}",to:'rene@zubcevic.com'
}
