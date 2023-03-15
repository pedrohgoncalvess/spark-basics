package init

import org.apache.spark.SparkContext

object initSpark extends App{

  def sparkContext: SparkContext = {
    val sc = new SparkContext("local", "InitSpark")
    sc
  }

  def readingTextFile {
    val sc:SparkContext = sparkContext //call sparkcontext

    val filePath: String = "C:\\Users\\Pedro\\Desktop\\WorkSpace\\Scala\\Datasets\\arq_csv.txt"
    val dataRDD = sc.textFile (filePath) //load file
    val numLines: Long = dataRDD.count () //quant of lines in file

    println (s"Number of rows: $numLines")
    dataRDD.take (13).foreach (println) //print lines of file
  }
  readingTextFile
}
