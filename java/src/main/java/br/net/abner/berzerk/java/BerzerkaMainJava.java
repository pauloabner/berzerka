package br.net.abner.berzerk.java;

import playn.core.PlayN;
import playn.java.JavaPlatform;

import br.net.abner.berzerk.core.BerzerkaMain;

public class BerzerkaMainJava {

  public static void main(String[] args) {
    JavaPlatform platform = JavaPlatform.register();
    platform.assets().setPathPrefix("br/net/abner/berzerk/resources");
    PlayN.run(new BerzerkaMain());
  }
}
