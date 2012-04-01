package menu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.GameFont;
import com.golden.gamedev.object.sprite.AdvanceSprite;

public class TopDownMenu extends GameObject {

	private GameFont font;
	private BufferedImage titleImage;
	private int option;
	private AdvanceSprite leftOptionSprite;
	
	private HashMap<String, Object> map;
	private List<String> optionNames;

	private int numOfOptions;

	public TopDownMenu(HashMap<String, Object> input) {
		super(null);
		map = new HashMap<String, Object>(input);
		numOfOptions = map.size();
		optionNames = new ArrayList<String>();
		for(String s: map.keySet()){
			optionNames.add(s);
		}
	}

	@Override
	public void initResources() {
		// TODO Auto-generated method stub
		font = fontManager.getFont(getImages("images/font.png", 16, 6));

		leftOptionSprite = new AdvanceSprite(getImages("images/charset.png",
				12, 7));
		leftOptionSprite.setAnimationFrame(new int[] { 15, 16, 17, 16 });
		leftOptionSprite.setAnimate(true);
		leftOptionSprite.setLoopAnim(true);
		leftOptionSprite.getAnimationTimer().setDelay(160);

		titleImage = getImage("images/title.png");
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(titleImage, 10, 10, null);
		
		int line = 200;
		for(String s: optionNames){
			font.drawString(g, s, 	GameFont.CENTER, 0, line, getWidth());
			line = line + 40;
		}
		
		int y = (option == 2) ? line : 200+(option*40);
		leftOptionSprite.render(g, 145, y);	

	}

	@Override
	public void update(long elapsedTime) {
		// TODO Auto-generated method stub
		leftOptionSprite.update(elapsedTime);

		if (keyPressed(KeyEvent.VK_DOWN)) {
			if (++option > 2) {
				option = 0;
			}
			playSound("sounds/time.wav");
		}

		if (keyPressed(KeyEvent.VK_UP)) {
			if (--option < 0) {
				option = 6;
			}
			playSound("sounds/time.wav");
		}

		if (keyPressed(KeyEvent.VK_ENTER)) {
			playSound("sounds/switch.wav");

			if (option == map.size()) {
				finish();
			}
			else{
				String optionName = optionNames.get(option);
				Object o = map.get(optionName);
			}
		}

	}

}
