package br.net.abner.berzerk.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import br.net.abner.berzerk.core.BerzerkMain;

public class BerzerkMainJava {

  public static void main(String[] args) {
    JavaPlatform.Config config = new JavaPlatform.Config();
    // use config to customize the Java platform, if needed
    JavaPlatform.register(config);
    PlayN.run(new BerzerkMain());
  }
}
