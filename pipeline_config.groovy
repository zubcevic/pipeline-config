allow_scm_jenkinsfile = false
skip_default_checkout = false

@merge libraries {
  git
  @override sonarqube
  notify
}

application_environments {
    dev
    prod
}

keywords {
    master = ~/^[Mm]aster$/
    develop = ~/^[Dd]evelop(ment|er|)$/
}
