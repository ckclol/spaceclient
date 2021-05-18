package space.util;

import java.awt.Color;
import java.util.Arrays;

import com.google.common.base.Preconditions;

import javafx.animation.Interpolator;

public class Gradient {

	public Color rgbGradient(String a, Color from, Color to, Interpolator interpolator) {

	    // interpolate each component separately 
	    final int r = interpolator.interpolate(from.getRed(), to.getRed(), a.length());
	    final int g = interpolator.interpolate(from.getGreen(), to.getGreen(), a.length());
	    final int b = interpolator.interpolate(from.getBlue(), to.getBlue(), a.length());
	    Color d = null;

	    final StringBuilder builder = new StringBuilder();

	    // create a string that matches the input-string but has
	    // the different color applied to each char
	    for (int i = 0; i < a.length(); i++) {
	    	
	    	 d = new Color(Math.round(r), Math.round(g), Math.round(b));
	    	
	    }

	    return d;
	}	
}
