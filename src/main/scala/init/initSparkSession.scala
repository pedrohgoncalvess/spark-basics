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

    println(s"Total number of rows: ${dataRDD.count()}")
  }


  def multiplesSparkSession: Unit = {
      val ss1 = SparkSession.builder()
        .master("local")
        .appName("Creating Multiple Spark Session")
        .getOrCreate()

    val ss2 = SparkSession.builder()
      .master("local")
      .appName("Creating Multiple Spark Session")
      .getOrCreate()

    val rdd1 = ss1.sparkContext.parallelize(Array(1,2,3,4,5,6,7,8,9))
    val rdd2 = ss2.sparkContext.parallelize(Array(1,2,3,4,5,6,7,8,9))

    rdd1.collect().foreach(println)
    rdd2.collect().foreach(println)
  }


  //multiplesSparkSession
  basicReadCSVFile("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv")
}
