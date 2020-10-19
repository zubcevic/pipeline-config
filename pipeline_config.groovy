libraries{
  merge = true 
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
