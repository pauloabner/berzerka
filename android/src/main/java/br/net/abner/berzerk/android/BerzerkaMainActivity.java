package br.net.abner.berzerk.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import br.net.abner.berzerk.core.BerzerkaMain;

public class BerzerkaMainActivity extends GameActivity {

  @Override
  public void main(){
    platform().assets().setPathPrefix("br/net/abner/berzerk/resources");
    PlayN.run(new BerzerkaMain());
  }
}
