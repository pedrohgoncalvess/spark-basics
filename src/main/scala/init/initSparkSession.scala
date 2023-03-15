package init

import org.apache.spark.sql.SparkSession

object initSparkSession extends App {

  def createSparkSession:SparkSession = {
    val ss = SparkSession.builder()
      .appName("Creating Spark Session")
      .master("local")
      .getOrCreate()
    ss
  }

  def readCSVFile(path:String) = {
    val ss: SparkSession = createSparkSession

    val dataRDD = ss.sparkContext.textFile(path)

    val rowNum = dataRDD.count()
    println(s"Number of rows: $rowNum")
    dataRDD.take(15).foreach(println)

    val header = dataRDD.first()
    val csvRDDWithoutHeader = dataRDD.filter(_ != header)
    csvRDDWithoutHeader.take(10).foreach(println)

  }
  readCSVFile("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv")
}
