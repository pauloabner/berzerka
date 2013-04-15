package br.net.abner.berzerk.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import br.net.abner.berzerk.core.BerzerkMain;

public class BerzerkMainHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("berzerk/");
    PlayN.run(new BerzerkMain());
  }
}
