import mill._
import mill.scalalib._

object bla extends ScalaModule {
  def scalaVersion = "2.13.2"
}

def pathRef() = T.command {
  scalalib.ZincWorkerModule.classpath().foreach { p =>
    for ((_, attrs) <- os.walk.attrs(p.path, includeTarget = true, followLinks = true)) {
      T.log.info(s"${p.path} -> ${attrs.mtime}:${attrs.size} -> ${p.sig}")
    }
  }
}
