package oreonworlds.gui;

import engine.core.RenderingEngine;
import engine.core.Window;
import engine.math.Vec2f;
import engine.textures.Texture2D;
import modules.gui.Button;

public class MotionBlurButton extends Button{

	public MotionBlurButton()
	{
		if (RenderingEngine.isMotionBlurEnabled()){
			buttonMap = new Texture2D("./res/gui/tex/checkbox_x.png");
			buttonClickMap = new Texture2D("./res/gui/tex/checkbox_x.png");
		}
		else {
			buttonMap = new Texture2D("./res/gui/tex/checkbox.png");
			buttonClickMap = new Texture2D("./res/gui/tex/checkbox.png");
		}
		getOrthoTransform().setTranslation(210, Window.getInstance().getHeight()-142, 0);
		getOrthoTransform().setScaling(15, 25, 0);
		Vec2f[] texCoords = new Vec2f[4];
		texCoords[0] = new Vec2f(0,1f);
		texCoords[1] = new Vec2f(0,0);
		texCoords[2] = new Vec2f(1,0);
		texCoords[3] = new Vec2f(1,1f);
		setTexCoords(texCoords);
	}
	
	@Override
	public void onClickActionPerformed()
	{
		if (RenderingEngine.isMotionBlurEnabled()){
			RenderingEngine.setMotionBlurEnabled(false);
			buttonMap = new Texture2D("./res/gui/tex/checkbox.png");
			buttonClickMap = new Texture2D("./res/gui/tex/checkbox.png");
		}
		else {
			RenderingEngine.setMotionBlurEnabled(true);
			buttonMap = new Texture2D("./res/gui/tex/checkbox_x.png");
			buttonClickMap = new Texture2D("./res/gui/tex/checkbox_x.png");
		}
	}
}
