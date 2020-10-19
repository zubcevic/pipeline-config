libraries{
  merge = true 
  git
  sonarqube
  notify
}

application_environments {
    dev
    prod
}

keywords {
    main = ~/^[Mm]ain(line|)$/
    develop = ~/^[Dd]evelop(ment|er|)$/
}
