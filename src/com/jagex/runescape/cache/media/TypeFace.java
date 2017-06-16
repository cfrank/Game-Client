package com.jagex.runescape.cache.media;

import com.jagex.runescape.cache.Archive;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.net.Buffer;

import java.util.Random;

public class TypeFace extends Rasterizer {


	public byte characterPixels[][] = new byte[256][];
	public int characterWidths[] = new int[256];
	public int characterHeights[] = new int[256];
	public int characterXOffsets[] = new int[256];
	public int characterYOffsets[] = new int[256];
	public int characterScreenWidths[] = new int[256];
	public int characterDefaultHeight;
	public Random random = new Random();
	public boolean strikethrough = false;

	public TypeFace(boolean large, Archive archive, String archiveName) {
		Buffer dataBuffer = new Buffer(archive.getFile(archiveName + ".dat"));
		Buffer indexBuffer = new Buffer(archive.getFile("index.dat"));
		indexBuffer.currentPosition = dataBuffer.getUnsignedLEShort() + 4;
		int k = indexBuffer.getUnsignedByte();
		if (k > 0)
			indexBuffer.currentPosition += 3 * (k - 1);
		for (int character = 0; character < 256; character++) {
			characterXOffsets[character] = indexBuffer.getUnsignedByte();
			characterYOffsets[character] = indexBuffer.getUnsignedByte();
			int characterWidth = characterWidths[character] = indexBuffer.getUnsignedLEShort();
			int characterHeight = characterHeights[character] = indexBuffer.getUnsignedLEShort();
			int characterType = indexBuffer.getUnsignedByte();
			int characterSize = characterWidth * characterHeight;
			characterPixels[character] = new byte[characterSize];
			if (characterType == 0) {
				for (int pixel = 0; pixel < characterSize; pixel++)
					characterPixels[character][pixel] = dataBuffer.getSignedByte();

			} else if (characterType == 1) {
				for (int characterX = 0; characterX < characterWidth; characterX++) {
					for (int characterY = 0; characterY < characterHeight; characterY++)
						characterPixels[character][characterX + characterY * characterWidth] = dataBuffer.getSignedByte();

				}

			}
			if (characterHeight > characterDefaultHeight && character < 128)
				characterDefaultHeight = characterHeight;
			characterXOffsets[character] = 1;
			characterScreenWidths[character] = characterWidth + 2;
			int pixelCount = 0;
			for (int characterY = characterHeight / 7; characterY < characterHeight; characterY++)
				pixelCount += characterPixels[character][characterY * characterWidth];

			if (pixelCount <= characterHeight / 7) {
				characterScreenWidths[character]--;
				characterXOffsets[character] = 0;
			}
			pixelCount = 0;
			for (int characterY = characterHeight / 7; characterY < characterHeight; characterY++)
				pixelCount += characterPixels[character][(characterWidth - 1) + characterY * characterWidth];

			if (pixelCount <= characterHeight / 7)
				characterScreenWidths[character]--;
		}

		if (large) {
			characterScreenWidths[32] = characterScreenWidths[73];
		} else {
			characterScreenWidths[32] = characterScreenWidths[105];
		}
	}

	public void drawStringRight(String string, int x, int y, int colour) {
		drawString(string, x - getStringWidth(string), y, colour);
	}

	public void drawStringLeft(String string, int x, int y, int colour) {
		drawString(string, x - getStringWidth(string) / 2, y, colour);
	}

	public void drawStringCenter(String string, int x, int y, int colour, boolean shadowed) {
		drawShadowedString(string, x - getStringEffectWidth(string) / 2, y, shadowed, colour);
	}

	public int getStringEffectWidth(String string) {
		if (string == null)
			return 0;
		int width = 0;
		for (int character = 0; character < string.length(); character++)
			if (string.charAt(character) == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@')
				character += 4;
			else
				width += characterScreenWidths[string.charAt(character)];

		return width;
	}

	public int getStringWidth(String string) {
		if (string == null)
			return 0;
		int width = 0;
		for (int character = 0; character < string.length(); character++)
			width += characterScreenWidths[string.charAt(character)];

		return width;
	}

	public void drawString(String string, int x, int y, int colour) {
		if (string == null)
			return;
		y -= characterDefaultHeight;
		for (int index = 0; index < string.length(); index++) {
			char character = string.charAt(index);
			if (character != ' ')
				drawCharacter(characterPixels[character], x + characterXOffsets[character], y + characterYOffsets[character], characterWidths[character],
						characterHeights[character], colour);
			x += characterScreenWidths[character];
		}

	}

	public void drawCenteredStringWaveY(String string, int x, int y, int wave, int colour) {
		if (string == null)
			return;
		x -= getStringWidth(string) / 2;
		y -= characterDefaultHeight;
		for (int index = 0; index < string.length(); index++) {
			char character = string.charAt(index);
			if (character != ' ')
				drawCharacter(characterPixels[character], x + characterXOffsets[character], y + characterYOffsets[character]
						+ (int) (Math.sin(index / 2D + wave / 5D) * 5D), characterWidths[character], characterHeights[character], colour);
			x += characterScreenWidths[character];
		}

	}

	public void drawCeneteredStringWaveXY(String string, int x, int y, int wave, int colour) {
		if (string == null)
			return;
		x -= getStringWidth(string) / 2;
		y -= characterDefaultHeight;
		for (int index = 0; index < string.length(); index++) {
			char character = string.charAt(index);
			if (character != ' ')
				drawCharacter(characterPixels[character], x + characterXOffsets[character] + (int) (Math.sin(index / 5D + wave / 5D) * 5D), y
						+ characterYOffsets[character] + (int) (Math.sin(index / 3D + wave / 5D) * 5D), characterWidths[character],
						characterHeights[character], colour);
			x += characterScreenWidths[character];
		}

	}

	public void drawCenteredStringWaveXYMove(String string, int x, int y, int waveAmount, int waveSpeed, int colour) {
		if (string == null)
			return;
		double speed = 7D - waveSpeed / 8D;
		if (speed < 0.0D)
			speed = 0.0D;
		x -= getStringWidth(string) / 2;
		y -= characterDefaultHeight;
		for (int index = 0; index < string.length(); index++) {
			char character = string.charAt(index);
			if (character != ' ')
				drawCharacter(characterPixels[character], x + characterXOffsets[character], y + characterYOffsets[character]
						+ (int) (Math.sin(index / 1.5D + waveAmount) * speed), characterWidths[character], characterHeights[character], colour);
			x += characterScreenWidths[character];
		}

	}

	public void drawShadowedString(String string, int x, int y, boolean shadow, int colour) {
		strikethrough = false;
		int originalX = x;
		if (string == null)
			return;
		y -= characterDefaultHeight;
		for (int character = 0; character < string.length(); character++)
			if (string.charAt(character) == '@' && character + 4 < string.length() && string.charAt(character + 4) == '@') {
				int stringColour = getColour(string.substring(character + 1, character + 4));
				if (stringColour != -1)
					colour = stringColour;
				character += 4;
			} else {
				char c = string.charAt(character);
				if (c != ' ') {
					if (shadow)
						drawCharacter(characterPixels[c], x + characterXOffsets[c] + 1, y + characterYOffsets[c] + 1,
								characterWidths[c], characterHeights[c], 0);
					drawCharacter(characterPixels[c], x + characterXOffsets[c], y + characterYOffsets[c], characterWidths[c],
							characterHeights[c], colour);
				}
				x += characterScreenWidths[c];
			}

		if (strikethrough)
			Rasterizer.drawHorizontalLine(originalX, y + (int) (characterDefaultHeight * 0.69999999999999996D), x - originalX, 0x800000);
	}

	public void drawShadowedSeededAlphaString(String string, int x, int y, int colour, int seed) {
		if (string == null)
			return;
		random.setSeed(seed);
		int alpha = 192 + (random.nextInt() & 0x1f);
		y -= characterDefaultHeight;
		for (int index = 0; index < string.length(); index++)
			if (string.charAt(index) == '@' && index + 4 < string.length() && string.charAt(index + 4) == '@') {
				int stringColour = getColour(string.substring(index + 1, index + 4));
				if (stringColour != -1)
					colour = stringColour;
				index += 4;
			} else {
				char c = string.charAt(index);
				if (c != ' ') {

					drawAlphaCharacter(x + characterXOffsets[c] + 1, true, 0, characterPixels[c],
								y + characterYOffsets[c] + 1, characterHeights[c], characterWidths[c], 192);
					drawAlphaCharacter(x + characterXOffsets[c], true, colour, characterPixels[c], y + characterYOffsets[c],
							characterHeights[c], characterWidths[c], alpha);
				}
				x += characterScreenWidths[c];
				if ((random.nextInt() & 3) == 0)
					x++;
			}

	}

	public int getColour(String code) {
		if (code.equals("red"))
			return 0xff0000;
		if (code.equals("gre"))
			return 65280;
		if (code.equals("blu"))
			return 255;
		if (code.equals("yel"))
			return 0xffff00;
		if (code.equals("cya"))
			return 65535;
		if (code.equals("mag"))
			return 0xff00ff;
		if (code.equals("whi"))
			return 0xffffff;
		if (code.equals("bla"))
			return 0;
		if (code.equals("lre"))
			return 0xff9040;
		if (code.equals("dre"))
			return 0x800000;
		if (code.equals("dbl"))
			return 128;
		if (code.equals("or1"))
			return 0xffb000;
		if (code.equals("or2"))
			return 0xff7000;
		if (code.equals("or3"))
			return 0xff3000;
		if (code.equals("gr1"))
			return 0xc0ff00;
		if (code.equals("gr2"))
			return 0x80ff00;
		if (code.equals("gr3"))
			return 0x40ff00;
		if (code.equals("str"))
			strikethrough = true;
		if (code.equals("end"))
			strikethrough = false;
		return -1;
	}

	public void drawCharacter(byte pixels[], int x, int y, int width, int height, int colour) {
		int rasterizerPixel = x + y * Rasterizer.width;
		int remainingWidth = Rasterizer.width - width;
		int characterPixelOffset = 0;
		int characterPixel = 0;
		if (y < Rasterizer.topY) {
			int offsetY = Rasterizer.topY - y;
			height -= offsetY;
			y = Rasterizer.topY;
			characterPixel += offsetY * width;
			rasterizerPixel += offsetY * Rasterizer.width;
		}
		if (y + height >= Rasterizer.bottomY)
			height -= ((y + height) - Rasterizer.bottomY) + 1;
		if (x < Rasterizer.topX) {
			int offsetX = Rasterizer.topX - x;
			width -= offsetX;
			x = Rasterizer.topX;
			characterPixel += offsetX;
			rasterizerPixel += offsetX;
			characterPixelOffset += offsetX;
			remainingWidth += offsetX;
		}
		if (x + width >= Rasterizer.bottomX) {
			int endOffsetX = ((x + width) - Rasterizer.bottomX) + 1;
			width -= endOffsetX;
			characterPixelOffset += endOffsetX;
			remainingWidth += endOffsetX;
		}
		if (width > 0 && height > 0) {
			drawCharacterPixels(pixels, Rasterizer.pixels, characterPixel, rasterizerPixel, characterPixelOffset, remainingWidth, width, height, colour);
		}
	}

	public void drawCharacterPixels(byte[] characterPixels, int[] rasterizerPixels, int characterPixel, int rasterizerPixel, int characterPixelOffset, int rasterizerPixelOffset, int width, int height, int colour) {
		int negativeQuaterWidth = -(width >> 2);
		width = -(width & 3);
		for (int heightCounter = -height; heightCounter < 0; heightCounter++) {
			for (int widthCounter = negativeQuaterWidth; widthCounter < 0; widthCounter++) {
				if (characterPixels[characterPixel++] != 0)
					rasterizerPixels[rasterizerPixel++] = colour;
				else
					rasterizerPixel++;
				if (characterPixels[characterPixel++] != 0)
					rasterizerPixels[rasterizerPixel++] = colour;
				else
					rasterizerPixel++;
				if (characterPixels[characterPixel++] != 0)
					rasterizerPixels[rasterizerPixel++] = colour;
				else
					rasterizerPixel++;
				if (characterPixels[characterPixel++] != 0)
					rasterizerPixels[rasterizerPixel++] = colour;
				else
					rasterizerPixel++;
			}

			for (int widthCounter = width; widthCounter < 0; widthCounter++)
				if (characterPixels[characterPixel++] != 0)
					rasterizerPixels[rasterizerPixel++] = colour;
				else
					rasterizerPixel++;

			rasterizerPixel += rasterizerPixelOffset;
			characterPixel += characterPixelOffset;
		}

	}

	public void drawAlphaCharacter(int x, boolean flag, int j, byte abyte0[], int y, int height, int width, int j1) {
		int rasterizerPixel = x + y * Rasterizer.width;
		int rasterizerPixelOffset = Rasterizer.width - width;
		int characterPixelOffset = 0;
		int characterPixel = 0;
		if (y < Rasterizer.topY) {
			int yOffset = Rasterizer.topY - y;
			height -= yOffset;
			y = Rasterizer.topY;
			characterPixel += yOffset * width;
			rasterizerPixel += yOffset * Rasterizer.width;
		}
		if (y + height >= Rasterizer.bottomY)
			height -= ((y + height) - Rasterizer.bottomY) + 1;
		if (x < Rasterizer.topX) {
			int xOffset = Rasterizer.topX - x;
			width -= xOffset;
			x = Rasterizer.topX;
			characterPixel += xOffset;
			rasterizerPixel += xOffset;
			characterPixelOffset += xOffset;
			rasterizerPixelOffset += xOffset;
		}
		if (x + width >= Rasterizer.bottomX) {
			int widthoffset = ((x + width) - Rasterizer.bottomX) + 1;
			width -= widthoffset;
			characterPixelOffset += widthoffset;
			rasterizerPixelOffset += widthoffset;
		}
		if (width > 0 && height > 0) {
			drawCharacterPixelsAlpha(characterPixel, rasterizerPixelOffset, characterPixelOffset, rasterizerPixel, j1, Rasterizer.pixels, j, 2, height, width, abyte0);
		}
	}

	public void drawCharacterPixelsAlpha(int characterPixel, int rasterizerPixelOffset, int characterPixelOffset, int rasterizerPixel, int alpha, int rasterizerPixels[], int colour, int k1, int height, int width, byte characterPixels[]) {
		colour = ((colour & 0xff00ff) * alpha & 0xff00ff00) + ((colour & 0xff00) * alpha & 0xff0000) >> 8;
		alpha = 256 - alpha;
		for (int heightCounter = -height; heightCounter < 0; heightCounter++) {
			for (int widthCounter = -width; widthCounter < 0; widthCounter++)
				if (characterPixels[characterPixel++] != 0) {
					int rasterizerPixelColor = rasterizerPixels[rasterizerPixel];
					rasterizerPixels[rasterizerPixel++] = (((rasterizerPixelColor & 0xff00ff) * alpha & 0xff00ff00) + ((rasterizerPixelColor & 0xff00) * alpha & 0xff0000) >> 8) + colour;
				} else {
					rasterizerPixel++;
				}

			rasterizerPixel += rasterizerPixelOffset;
			characterPixel += characterPixelOffset;
		}

	}

}
