package com.uc.web.utils.captcha;

import java.awt.image.BufferedImage;

public interface RandomCharImageGenerator {
	public BufferedImage generate(int width, int height, String captcha);
}
