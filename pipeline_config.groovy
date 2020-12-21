@merge libraries{
  git
  sonarqube
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
