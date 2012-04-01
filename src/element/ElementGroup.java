package element;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;

public class ElementGroup extends SpriteGroup{

	public ElementGroup(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Element[] getElement(){
		Sprite[] sprites = super.getSprites();
		Element[] elements = new Element[sprites.length];
		for(int i = 0; i < sprites.length; i++){
			elements[i] =(Element) sprites[i];
		}
		return  elements;
	}
}
