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

  def basicReadCSVFile(pathArq:String): Unit = {
    val ss: SparkSession = createSparkSession

    val dataRDD = ss.sparkContext.textFile(pathArq)

    val header = dataRDD.first() //HEADER OF DATASET
    val csvRDDWithoutHeader = dataRDD.filter(_ != header) //REMOVE HEADER
    csvRDDWithoutHeader.take(10).foreach(println)

    //val separetValues = csvRDDWithoutHeader.map(line => line.split(",")(0)) //SEPARATE DATASET WITH REGEX (0) IS INDEX OF COLUMN
    //separetValues.take(50).foreach(println)

    val separetColumns = csvRDDWithoutHeader.map(line => {
      val colArray = line.split(",")
      Array(colArray(0),colArray(1),colArray(2)).mkString(":") //mkString == separator value
    })

    separetColumns.take(10).foreach(println)

    separetColumns.saveAsTextFile("saveFolder\\FolderTest")
  }
  basicReadCSVFile("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv")
}
