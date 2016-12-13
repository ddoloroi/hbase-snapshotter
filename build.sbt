resolvers ++= Seq(
  "Hadoop Releases" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

libraryDependencies ++= Seq(
  "com.google.code.gson" % "gson" % "2.2.4",
  "com.typesafe" % "config" % "1.3.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  "org.apache.hadoop" % "hadoop-common" % "2.6.0",
  "org.apache.hbase" % "hbase-common" % "1.2.0-cdh5.8.2",
  "org.apache.hbase" % "hbase-client" % "1.2.0-cdh5.8.2",
  "org.apache.hbase" % "hbase-server" % "1.2.0-cdh5.8.2" excludeAll(
    ExclusionRule("org.mortbay.jetty")
  ),

  "org.apache.spark" %% "spark-core" % "2.0.2" % "provided",
  "org.apache.spark" %% "spark-hive" % "2.0.2" % "provided",
  "org.apache.spark" %% "spark-yarn" % "2.0.2" % "provided",
  "com.cloudera" % "spark-hbase" % "0.0.2-clabs" excludeAll(
    ExclusionRule("org.mortbay.jetty")
  ),

  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs @ _*) => MergeStrategy.last
  case PathList("javax", "activation", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case PathList("com", "google", xs @ _*) => MergeStrategy.last
  case PathList("com", "esotericsoftware", xs @ _*) => MergeStrategy.last
  case PathList("com", "codahale", xs @ _*) => MergeStrategy.last
  case PathList("com", "yammer", xs @ _*) => MergeStrategy.last
  case "overview.html" => MergeStrategy.rename
  case "plugin.xml" => MergeStrategy.rename
  case "parquet.thrift" => MergeStrategy.rename
  case "META-INF/ECLIPSEF.RSA" => MergeStrategy.last
  case "META-INF/mailcap" => MergeStrategy.last
  case "META-INF/mimetypes.default" => MergeStrategy.last
  case "plugin.properties" => MergeStrategy.last
  case "log4j.properties" => MergeStrategy.last

  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
