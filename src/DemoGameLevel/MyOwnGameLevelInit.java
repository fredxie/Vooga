package DemoGameLevel;

import java.util.List;

import levelEditor.Load;
import gameLevel.GameLevelInit;

public class MyOwnGameLevelInit extends GameLevelInit{
	
	public List<List<Object>> list = Load.list;
	
	public MyOwnGameLevelInit(MyOwnGameLevel gl) {
		super(gl);
	}

	public void parametersInit() {
		
	}

	public void backgroundInit() {
		
	}

	public void fighterInit() {
		
	}

	public void blockInit() {
		
	}


	public void bonusInit() {
	}

	
	public void enemyInit() {
	}

	public void cannonInit() {
		
	}

	
	public void collisionInit() {
		
	}

	public void keyInit() {
		
	}

}
