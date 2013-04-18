package br.net.abner.berzerk.core;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import static playn.core.PlayN.random;
import playn.core.Canvas;
import playn.core.CanvasImage;
import playn.core.Color;
import playn.core.Game;
import playn.core.GroupLayer;
import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Keyboard;
import playn.core.Keyboard.Event;
import playn.core.PlayN;

public class BerzerkMain extends Game.Default {

  private float physUnitPerScreenUnit = 1f;
private ImageLayer playerLayer;
private float dx = 1f;

public BerzerkMain() {
    super(33); // call update every 33ms (30 times per second)
  }

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
      playerLayer = graphics().createImageLayer(playerImage);
      playerLayer.setTranslation(width/8 - 12, height/2 - 20);
      graphics().rootLayer().add(playerLayer);
      
      //create and add enymies
      Image berzerkImage = assets().getImage("images/berzerk.png");
      float berzerkWidth = 32 * physUnitPerScreenUnit;
      float berzerHeight = 32 * physUnitPerScreenUnit ;
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
      
      CanvasImage scenarioBorderImage = graphics().createImage(width, height);
      Canvas scenarioCanvas = scenarioBorderImage.canvas();
      scenarioCanvas.setFillColor(Color.rgb(0, 0, 255));
      scenarioCanvas.fillRect(0, 0, width, 10);
      scenarioCanvas.fillRect(0, 0, 10, height);
      scenarioCanvas.fillRect(width - 10, 0, width, height);
      scenarioCanvas.fillRect(0, height -10, width, height);
      scenarioCanvas.fillRect(width/4, height/2 - 5 , width/2, 10);
      scenarioCanvas.fillRect(width/4 - 10, height/4, 10, height/2);
      scenarioCanvas.fillRect(3*width/4 , height/4, 10, height/2);
      
      ImageLayer scenarioLayer = graphics().createImageLayer(scenarioBorderImage);
      graphics().rootLayer().add(scenarioLayer); 
      
      PlayN.keyboard().setListener(new Keyboard.Adapter(){

		@Override
		public void onKeyDown(Event event) {
			// TODO Auto-generated method stub
			super.onKeyDown(event);
		}

		@Override
		public void onKeyUp(Event event) {
			// TODO Auto-generated method stub
			super.onKeyUp(event);
		}
    	  
      });
      
  }

  @Override
  public void update(int delta) {	  
	  playerLayer.setTx(playerLayer.tx() + dx );
	  playerLayer.setTy(playerLayer.ty() + dx );
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!
  }
  
  
}
