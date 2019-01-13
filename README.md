# Play Framework 2.6
Play Framework application working with sub projects in a single build.

## Getting started

### Install sbt
Download sbt from [https://www.scala-sbt.org/download.html](https://www.scala-sbt.org/download.html) 

### Run Play

Run all project:
```
$ cd play-application
[play-application] $  sbt runAll
```

Run each project individually:
```
$ sbt
[play-application] $ projects
[info] In file:/Users/ysuzuki/workspace/play/play-application/
[info]   * root
[info]     search
[play-application] $ project search
[search] $ run 9001

```

## API Endpoints
### GET /github/search
[http://localhost:9000/github/search?q=scala](http://localhost:9000/github/search?q=scala)



## Refs
### Create new application
https://www.playframework.com/documentation/2.6.x/SBTSubProjects
