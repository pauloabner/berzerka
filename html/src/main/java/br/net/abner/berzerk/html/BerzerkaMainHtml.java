package br.net.abner.berzerk.html;

import playn.core.PlayN;
import playn.html.HtmlGame;
import playn.html.HtmlPlatform;

import br.net.abner.berzerk.core.BerzerkaMain;

public class BerzerkaMainHtml extends HtmlGame {

  @Override
  public void start() {
    HtmlPlatform platform = HtmlPlatform.register();
    platform.assets().setPathPrefix("berzerk/");
    PlayN.run(new BerzerkaMain());
  }
}
