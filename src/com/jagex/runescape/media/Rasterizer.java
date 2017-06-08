package com.jagex.runescape.media;

import com.jagex.runescape.collection.CacheableNode;

public class Rasterizer extends CacheableNode {

	public static int[] pixels;
	public static int width;
	public static int height;
	public static int topY;
	public static int bottomY;
	public static int topX;
	public static int bottomX;
	public static int virtualBottomX;
	public static int centerX;
	public static int centerY;


	public static void createRasterizer(int[] pixels, int width, int height) {
		Rasterizer.pixels = pixels;
		Rasterizer.width = width;
		Rasterizer.height = height;
		setCoordinates(0, 0, height, width);
	}

	public static void resetCoordinates() {
		topX = 0;
		topY = 0;
		bottomX = width;
		bottomY = height;
		virtualBottomX = bottomX - 1;
		centerX = bottomX / 2;
	}

	public static void setCoordinates(int y, int x, int height, int width) {
		if (x < 0)
			x = 0;
		if (y < 0)
			y = 0;
		if (width > Rasterizer.width)
			width = Rasterizer.width;
		if (height > Rasterizer.height)
			height = Rasterizer.height;
		topX = x;
		topY = y;
		bottomX = width;
		bottomY = height;
		virtualBottomX = bottomX - 1;
		centerX = bottomX / 2;
		centerY = bottomY / 2;

	}

	public static void resetPixels() {
		int pixelCount = width * height;
		for (int pixel = 0; pixel < pixelCount; pixel++)
			pixels[pixel] = 0;

	}

	public static void drawFilledRectangleAlhpa(int x, int y, int width, int height, int colour, int alpha) {
		if (x < topX) {
			width -= topX - x;
			x = topX;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (x + width > bottomX)
			width = bottomX - x;
		if (y + height > bottomY)
			height = bottomY - y;
		int a = 256 - alpha;
		int r = (colour >> 16 & 0xff) * alpha;
		int g = (colour >> 8 & 0xff) * alpha;
		int b = (colour & 0xff) * alpha;
		int widthOffset = Rasterizer.width - width;
		int pixel = x + y * Rasterizer.width;
		for (int heightCounter = 0; heightCounter < height; heightCounter++) {
			for (int widthCounter = -width; widthCounter < 0; widthCounter++) {
				int red = (pixels[pixel] >> 16 & 0xff) * a;
				int green	 = (pixels[pixel] >> 8 & 0xff) * a;
				int blue = (pixels[pixel] & 0xff) * a;
				int rgba = ((r + red >> 8) << 16) + ((g + green >> 8) << 8) + (b + blue >> 8);
				pixels[pixel++] = rgba;
			}

			pixel += widthOffset;
		}

	}

	public static void drawFilledRectangle(int x, int y, int width, int height, int colour) {
		if (x < topX) {
			width -= topX - x;
			x = topX;
		}
		if (y < topY) {
			height -= topY - y;
			y = topY;
		}
		if (x + width > bottomX)
			width = bottomX - x;
		if (y + height > bottomY)
			height = bottomY - y;
		int pixelOffset = Rasterizer.width - width;
		int pixel = x + y * Rasterizer.width;
		for (int heightCounter = -height; heightCounter < 0; heightCounter++) {
			for (int widthCounter = -width; widthCounter < 0; widthCounter++)
				pixels[pixel++] = colour;

			pixel += pixelOffset;
		}
	}

	public static void drawUnfilledRectangle(int x, int y, int width, int height, int color) {
		drawHorizontalLine(x, y, width, color);
		drawHorizontalLine(x, (y + height) - 1, width, color);
		drawVerticalLine(x, y, height, color);
		drawVerticalLine((x + width) - 1, y, height, color);
	}

	public static void drawUnfilledRectangleAlpha(int x, int y, int width, int height, int colour, int alpha) {
		drawHorizontalLineAlpha(x, y, width, colour, alpha);
		drawHorizontalLineAlpha(x, (y + height) - 1, width, colour, alpha);
		if (height >= 3) {
			drawVerticalLineAlpha(x, y + 1, height - 2, colour, alpha);
			drawVerticalLineAlpha((x + width) - 1, y + 1, height - 2, colour, alpha);
		}
	}

	public static void drawHorizontalLine(int x, int y, int lenght, int colour) {
		if (y < topY || y >= bottomY)
			return;
		if (x < topX) {
			lenght -= topX - x;
			x = topX;
		}
		if (x + lenght > bottomX)
			lenght = bottomX - x;
		int pixelOffset = x + y * width;
		for (int pixel = 0; pixel < lenght; pixel++)
			pixels[pixelOffset + pixel] = colour;

	}

	public static void drawHorizontalLineAlpha(int x, int y, int length, int colour, int alpha) {
		if (y < topY || y >= bottomY)
			return;
		if (x < topX) {
			length -= topX - x;
			x = topX;
		}
		if (x + length > bottomX)
			length = bottomX - x;
		int a = 256 - alpha;
		int r = (colour >> 16 & 0xff) * alpha;
		int g = (colour >> 8 & 0xff) * alpha;
		int b = (colour & 0xff) * alpha;
		int pixelOffset = x + y * width;
		for (int lengthCounter = 0; lengthCounter < length; lengthCounter++) {
			int red = (pixels[pixelOffset] >> 16 & 0xff) * a;
			int green = (pixels[pixelOffset] >> 8 & 0xff) * a;
			int blue = (pixels[pixelOffset] & 0xff) * a;
			int rgba = ((r + red >> 8) << 16) + ((g + green >> 8) << 8) + (b + blue >> 8);
			pixels[pixelOffset++] = rgba;
		}
	}

	public static void drawVerticalLine(int x, int y, int lenght, int colour) {
		if (x < topX || x >= bottomX)
			return;
		if (y < topY) {
			lenght -= topY - y;
			y = topY;
		}
		if (y + lenght > bottomY)
			lenght = bottomY - y;
		int pixelOffset = x + y * width;
		for (int pixel = 0; pixel < lenght; pixel++)
			pixels[pixelOffset + pixel * width] = colour;

	}

	public static void drawVerticalLineAlpha(int x, int y, int lenght, int colour, int alpha) {
		if (x < topX || x >= bottomX)
			return;
		if (y < topY) {
			lenght -= topY - y;
			y = topY;
		}
		if (y + lenght > bottomY)
			lenght = bottomY - y;
		int a = 256 - alpha;
		int r = (colour >> 16 & 0xff) * alpha;
		int g = (colour >> 8 & 0xff) * alpha;
		int b = (colour & 0xff) * alpha;
		int pixel = x + y * width;
		for (int lengthCounter = 0; lengthCounter < lenght; lengthCounter++) {
			int red = (pixels[pixel] >> 16 & 0xff) * a;
			int blue = (pixels[pixel] >> 8 & 0xff) * a;
			int green = (pixels[pixel] & 0xff) * a;
			int rgba = ((r + red >> 8) << 16) + ((g + blue >> 8) << 8) + (b + green >> 8);
			pixels[pixel] = rgba;
			pixel += width;
		}

	}

	public Rasterizer() {
	}



}
