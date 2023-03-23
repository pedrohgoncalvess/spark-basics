package init

import init.initSparkSession.createSparkSession
import org.apache.spark.sql
import org.apache.spark.sql.SparkSession

object parquetFiles extends App{

  def transformFileSQLDataFrame(pathArq: String, format: String = "csv"): sql.DataFrame = {
    val ss: SparkSession = createSparkSession

    format match {
      case "csv" => ss.read.csv(pathArq)
      case "json" => ss.read.json(pathArq)
      case "parquet" => ss.read.json(pathArq)
      case "text" => ss.read.text(pathArq)
      case _ => ss.read.csv(pathArq)
    }
  } //this function works with any file formats

  def saveParquetFile(pathSave: String = "C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\saveFiles",
                      dataSet: sql.DataFrame,
                      folderName: String = "defaultParquet"): Unit = {
    dataSet.write.parquet(s"$pathSave\\$folderName")
  }

  def readParquetFile(pathArq:String = "C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\saveFiles\\defaultParquet"): Unit = {
    val ss: SparkSession = createSparkSession
    val parquetData = ss.read
      .option("header","true")
      .parquet(pathArq)

    val rowsData = parquetData.count()
    parquetData.show(15)
    parquetData.columns.foreach(println)
    println(s"Total rows number is: $rowsData")
  }
  //saveParquetFile("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\saveFiles\\", //call function to extract the dataframe
    //transformFileSQLDataFrame("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv")) //pass other function with return is SQL Dataframe
  readParquetFile()

}
