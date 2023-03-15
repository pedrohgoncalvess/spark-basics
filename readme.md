<h1 align="center">Environment configuration</h1>
<p>In my short experience learning frameworks and
programming languages I noticed that my biggest difficulty is environment configuration,
specifically with versions, so here's a good practice,
I'll write down the versions and configurations that I usually use. 
</p>
<hr>
<h2 align="center">Versions</h2>

> IDE: Intellij

> JDK: 11.0.17
<p>I can configure jdk that execute in project in intellij</p>

> Scala: 2.12.10

> Spark Version: 3.1.2

<h2 align="center">build.sbt</h2>

```
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.10"

val sparkVersion = "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "spark-config-default"
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion
```
<p>You can add more dependencies. If it is another spark then use sparkVersion variable to specify the version</p>