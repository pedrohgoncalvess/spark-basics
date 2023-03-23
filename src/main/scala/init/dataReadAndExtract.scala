package init

import init.initSparkSession.createSparkSession
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object dataReadAndExtract extends App{

  def readCSVFileForSave(path: String): RDD[String] = {
    val ss: SparkSession = createSparkSession

    val dataRDD = ss.sparkContext.textFile(path)

    val header = dataRDD.first()
    val csvRDDWithoutHeader = dataRDD.filter(_ != header)

    val separetColumns = csvRDDWithoutHeader.map(line => {
      val colArray = line.split(",")
      Array(colArray(0), colArray(1), colArray(2)).mkString(":")
    })
    separetColumns
  }

  def saveTextFile(pathSave: String = "C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\saveFiles",
                   nameFolder: String = "defaultNameFolder",
                   dataRDD: RDD[String]): Unit = {

    dataRDD.saveAsTextFile(s"$pathSave/$nameFolder") //METHOD FOR SAVE RDD TEXT FILE FORMAT

  }

  //saveTextFile(dataRDD = readCSVFileForSave("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv"))
}
