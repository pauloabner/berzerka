package br.net.abner.berzerk.android;

import playn.android.GameActivity;
import playn.core.PlayN;

import br.net.abner.berzerk.core.BerzerkMain;

public class BerzerkMainActivity extends GameActivity {

  @Override
  public void main(){
    PlayN.run(new BerzerkMain());
  }
}
