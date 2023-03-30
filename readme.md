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

> Scala: 2.12.10

> Spark Version: 3.1.2

> Hadoop: 2.7.2 

<h4>Explanations:</h4>
<p>Spark is compatible with JDK 8.x, 11.x, 17.x similar with others frameworks like PlayFramework and not every Spark version is compatible with every Scala version, in this case Spark 3.1.2 is compatible with Scala 2.12.10.
About jdk exist most ways of control this, on intellij creating project you can change the jdk version 
</p>
<hr>
<p>For Hadoop works in/with Spark you need to create the environment variable. For make this, you need to create new path with name "HADOOP_HOME" and value with path of hadoop directory <b>WITHOUT</b> \bin, after this you need to edit Path and add new value with <b>"%HADOOP_HOME%\bin</b></p>


<h2 align="center">build.sbt</h2>

```
ThisBuild / version := "0.0.0-YOUR_VERSION"

ThisBuild / scalaVersion := "2.12.10"

val sparkVersion = "3.1.2"

lazy val root = (project in file("."))
  .settings(
    name := "YOUR_PROJECT_NAME"
    //You can write the dependencies here too
  )

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion
```
<hr></hr>
<p>You can add more dependencies. If it is another spark then use sparkVersion variable to specify the version</p>

<h2 align='center'>Dataset</h2>
<p>I used a public dataset that contains popularity and other informations of music in spotify. 
Available in Kaggle (excelent platform for learn data sci/data eng). Link below</p>

>Number of rows is 26,173,515 (26 million).

> Archive size is.

- Unzipped 3,401,833 KB (3.4 GB).

- Zipped 967.994 KB (967 MB).

<div align="center">

[charts.csv / Kaggle](https://www.kaggle.com/datasets/dhruvildave/spotify-charts)

</div>