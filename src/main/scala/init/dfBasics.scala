package init

import init.initSparkSession.createSparkSession
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object dfBasics extends App{
  /**
   * In Spark 1.x data frame is created using SQL Context
   * and SQL Context is created using Spark Context
   */
  def basicDataFrame: Unit = {
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
  basicDataFrame
}
