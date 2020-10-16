@AfterStep({ context.step.equals("build") })
void call(context){
    /*
        execute something right before the library step called
        build is executed.
    */
    println("build step finished: ${context.status}")
}
