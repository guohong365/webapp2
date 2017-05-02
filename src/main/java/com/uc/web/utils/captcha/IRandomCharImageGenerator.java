package com.uc.web.utils.captcha;

import java.awt.image.BufferedImage;

public interface IRandomCharImageGenerator {
	public BufferedImage generate(int width, int height, String captcha);
}
