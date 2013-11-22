name := "attic"

organization := "attic"

version := "0.1.0-SNAPSHOT"

homepage := Some(url("https://github.com/BTBurke/skeleton-vagrant-scala-sbt"))

startYear := Some(2013)

scmInfo := Some(
  ScmInfo(
    url("https://github.com/BTBurke/attic-scala"),
    "scm:git:https://github.com/BTBurke/attic-scala.git",
    Some("scm:git:git@github.com:BTBurke/attic-scala.git")
  )
)

/* scala versions and options */
scalaVersion := "2.10.3"

crossScalaVersions := Seq(
/*  "2.9.3-RC1",
  "2.9.2",
  "2.9.1", "2.9.1-1",
  "2.9.0", "2.9.0-1",
  "2.8.0", "2.8.1", "2.8.2" */
)

// These options will be used for *all* versions.
scalacOptions ++= Seq(
  "-deprecation"
  ,"-unchecked"
  ,"-encoding", "UTF-8"
  ,"-target:jvm-1.7"
  // "-optimise"   // this option will slow your build
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline"
)

// These language flags will be used only for 2.10.x.
// Uncomment those you need, or if you hate SIP-18, all of them.
scalacOptions <++= scalaVersion map { sv =>
  if (sv startsWith "2.10") List(
    "-Xverify"
    ,"-Ywarn-all"
    ,"-feature"
    ,"-language:postfixOps"
    // "-language:reflectiveCalls",
    // "-language:implicitConversions"
    // "-language:higherKinds",
    // "-language:existentials",
    // "-language:experimental.macros",
    // "-language:experimental.dynamics"
  )
  else Nil
}

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq (
  "org.scalatest" % "scalatest_2.10" % "2.0.M5b" % "test"
)

/* you may need these repos */
resolvers ++= Seq(
  // Resolver.sonatypeRepo("snapshots")
  // Resolver.typesafeRepo("releases")
  // "spray repo" at "http://repo.spray.io"
)

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("attic.Main")

assemblySettings

test in AssemblyKeys.assembly := {}
