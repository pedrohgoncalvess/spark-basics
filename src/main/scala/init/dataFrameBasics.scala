package init

import init.initSparkSession.createSparkSession
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object dataFrameBasics extends App{
  /**
   * In Spark 1.x data frame is created using SQL Context
   * and SQL Context is created using Spark Context
   */
  def creatingDataFrameSpark: Unit = {
    val ss: SparkSession = createSparkSession

    val rdd = ss.sparkContext.parallelize(Array(1,2,3,4,5))
    val schema = StructType(
      StructField("Numbers",IntegerType,false) :: Nil
    )
    val rowRDD = rdd.map(line => Row(line))
    val df = ss.createDataFrame(rowRDD,schema)

    df.printSchema()
    df.show()
  }

  def dataFrameReadingCSV: Unit = {
    val ss: SparkSession = createSparkSession
    val properties = Map("header" -> "true","inferSchema" -> "true")

    val df = ss.read
      .option("header","true") //use first row as column name
      .option("inferSchema","true")
      //.options(properties) //its works too
      .csv("C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\charts.csv")
    df.printSchema()
    df.show(15)

  }
  //creatingDataFrameSpark
  dataFrameReadingCSV
}
