package com.uc.web.utils.captcha;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomCharImageCaptcha extends AbstractCaptcha {
	 
	private static final int DEFAULT_IMAGE_WIDTH=80;
	private static final int DEFAULT_IMAGE_HEIGHT=26;
	
	private ICharCodeCaptchaGenerator captchaGenerator;
	private ICharCodeCaptchaGenerator defaultCaptchaGenerator=new DetaultCaptchaGenerator();
	private IRandomCharImageGenerator charImageGenerator;
	private Random random=new Random();
	private int captchaCount;
	private int imageWidth;
	private int imageHeight;
	
	public ICharCodeCaptchaGenerator getCaptchaGenerator() {
		if(captchaGenerator==null)
			return defaultCaptchaGenerator;
		return captchaGenerator;
	}

	public void setCaptchaGenerator(ICharCodeCaptchaGenerator captchaGenerator) {
		this.captchaGenerator = captchaGenerator;
	}

	public int getCaptchaCount() {
		return captchaCount;
	}

	public void setCaptchaCount(int captchaCount) {
		this.captchaCount = captchaCount;
	}

	public int getImageWidth() {
		if(imageWidth<=0)
			return DEFAULT_IMAGE_WIDTH;
		return imageWidth;
	}

	public void setImageWidth(int imageWidth) {
		this.imageWidth = imageWidth;
	}

	public int getImageHeight() {
		if(imageHeight<=0)
			return DEFAULT_IMAGE_HEIGHT;
		return imageHeight;
	}

	public void setImageHeight(int imageHeight) {
		this.imageHeight = imageHeight;
	}

	public IRandomCharImageGenerator getCharImageGenerator() {
		return charImageGenerator;
	}

	public void setCharImageGenerator(IRandomCharImageGenerator charImageGenerator) {
		this.charImageGenerator = charImageGenerator;
	}

	protected String getRandomCaptcha(int count, String charSet){
		StringBuilder buff=new StringBuilder();
		for(int i=0; i< count; i++){
			buff.append(charSet.charAt(random.nextInt(charSet.length()-1)));
		}
		return buff.toString();		
	}
	
	protected void outputImage(String captcha, BufferedImage image, HttpServletResponse response, HttpServletRequest request) throws IOException{
		response.setDateHeader("Expires", 0);  
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
        response.setHeader("Pragma", "no-cache");  
        response.setContentType("image/jpeg");
        
        request.getSession().setAttribute(getCaptchaKey(), captcha);
        OutputStream outputStream=response.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);
        outputStream.flush();        
	}

	@Override
	public void requestCaptcha(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String captcha=	getCaptchaGenerator().generate(captchaCount);
		BufferedImage image=getCharImageGenerator().generate(getImageWidth(), getImageHeight(), captcha);
		outputImage(captcha, image, response, request);		
	}

}
