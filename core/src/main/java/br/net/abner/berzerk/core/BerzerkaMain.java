package br.net.abner.berzerk.core;

import static playn.core.PlayN.*;
import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.Color;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;

public class BerzerkaMain implements Game {
  private float physUnitPerScreenUnit = 1f;

@Override
  public void init() {
    // create and add black background image layer
	  int width = 640;
	  int height = 480;
	  CanvasImage bgImage = graphics().createImage(width, height);
	  Canvas canvas = bgImage.canvas();
	  canvas.setFillColor(Color.rgb(0,0,0));
	  canvas.fillRect(0, 0, width, height);
	  ImageLayer bg = graphics().createImageLayer(bgImage);
	  graphics().rootLayer().add(bg);

	  //create and add player
	  Image playerImage = assets().getImage("images/player.png");
	  ImageLayer playerLayer = graphics().createImageLayer(playerImage);
	  playerLayer.setTranslation(width/8 - 12, height/2 - 20);
	  graphics().rootLayer().add(playerLayer);
	  
	  //create and add enymies
	  Image berzerkImage = assets().getImage("images/berzerk.png");
	  float berzerkWidth = 32 * physUnitPerScreenUnit;
	  float berzerHeight = 32 * physUnitPerScreenUnit;
	  GroupLayer enimiesLayer = graphics().createGroupLayer();
	  enimiesLayer.setScale(1f / physUnitPerScreenUnit);
	  
	  
	  for(int i = 0; i < 6; i++){
		  ImageLayer enimyLayer = graphics().createImageLayer(berzerkImage);
		  float positionX = random()*width;
		  float positionY = random()*height;
		  if(positionX < 0) positionX += berzerkWidth;
		  if(positionX > width - berzerkWidth) positionX -= berzerkWidth;
		  if(positionY < 0) positionY += berzerHeight;
		  if(positionY > height - berzerHeight) positionY -= berzerHeight;
		  enimyLayer.setTranslation(positionX, positionY);
		  enimiesLayer.add(enimyLayer);
	  }
	  
	  graphics().rootLayer().add(enimiesLayer);
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }

  @Override
  public void update(float delta) {
  }

  @Override
  public int updateRate() {
    return 25;
  }
}
