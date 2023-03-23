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
libraryDependencies += "com.databricks" %% "spark-csv" % "1.5.0"