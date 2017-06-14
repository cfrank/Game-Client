package com.jagex.runescape;

import com.jagex.runescape.cache.Archive;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.net.Buffer;

public class IndexedImage extends Rasterizer {

    public byte[] pixels;
    public int[] palette;
    public int width;
    public int anInt1519;
    public int anInt1520;
    public int anInt1521;
    public int anInt1522;
    public int anInt1523;

    public IndexedImage(Archive archive, String archiveName, int i) {
        Buffer class50_sub1_sub2 = new Buffer(archive.getFile(archiveName + ".dat"));
        Buffer class50_sub1_sub2_1 = new Buffer(archive.getFile("index.dat"));
        class50_sub1_sub2_1.currentPosition = class50_sub1_sub2.getUnsignedLEShort();
        anInt1522 = class50_sub1_sub2_1.getUnsignedLEShort();
        anInt1523 = class50_sub1_sub2_1.getUnsignedLEShort();
        int j = class50_sub1_sub2_1.getUnsignedByte();
        palette = new int[j];
        for (int k = 0; k < j - 1; k++)
            palette[k + 1] = class50_sub1_sub2_1.get24BitInt();

        for (int l = 0; l < i; l++) {
            class50_sub1_sub2_1.currentPosition += 2;
            class50_sub1_sub2.currentPosition += class50_sub1_sub2_1.getUnsignedLEShort() * class50_sub1_sub2_1.getUnsignedLEShort();
            class50_sub1_sub2_1.currentPosition++;
        }

        anInt1520 = class50_sub1_sub2_1.getUnsignedByte();
        anInt1521 = class50_sub1_sub2_1.getUnsignedByte();
        width = class50_sub1_sub2_1.getUnsignedLEShort();
        anInt1519 = class50_sub1_sub2_1.getUnsignedLEShort();
        int i1 = class50_sub1_sub2_1.getUnsignedByte();
        int j1 = width * anInt1519;
        pixels = new byte[j1];
        if (i1 == 0) {
            for (int k1 = 0; k1 < j1; k1++)
                pixels[k1] = class50_sub1_sub2.getSignedByte();

            return;
        }
        if (i1 == 1) {
            for (int l1 = 0; l1 < width; l1++) {
                for (int i2 = 0; i2 < anInt1519; i2++)
                    pixels[l1 + i2 * width] = class50_sub1_sub2.getSignedByte();

            }

        }
    }

    public void method485(int i) {
        anInt1522 /= 2;
        anInt1523 /= 2;
        byte abyte0[] = new byte[anInt1522 * anInt1523];
        int j = 0;
        if (i != 0)
            return;
        for (int k = 0; k < anInt1519; k++) {
            for (int l = 0; l < width; l++)
                abyte0[(l + anInt1520 >> 1) + (k + anInt1521 >> 1) * anInt1522] = pixels[j++];

        }

        pixels = abyte0;
        width = anInt1522;
        anInt1519 = anInt1523;
        anInt1520 = 0;
        anInt1521 = 0;
    }

    public void method486(boolean flag) {
        if (width == anInt1522 && anInt1519 == anInt1523)
            return;
        byte abyte0[] = new byte[anInt1522 * anInt1523];
        int i = 0;
        for (int j = 0; j < anInt1519; j++) {
            for (int k = 0; k < width; k++)
                abyte0[k + anInt1520 + (j + anInt1521) * anInt1522] = pixels[i++];

        }

        pixels = abyte0;
        width = anInt1522;
        if (!flag) {
            return;
        } else {
            anInt1519 = anInt1523;
            anInt1520 = 0;
            anInt1521 = 0;
            return;
        }
    }

    public void flipHorizontal() {
        byte abyte0[] = new byte[width * anInt1519];
        int j = 0;
        for (int k = 0; k < anInt1519; k++) {
            for (int l = width - 1; l >= 0; l--)
                abyte0[j++] = pixels[l + k * width];

        }

        pixels = abyte0;
        anInt1520 = anInt1522 - width - anInt1520;

    }

    public void flipVertical() {
        byte abyte0[] = new byte[width * anInt1519];
        int i = 0;
        for (int j = anInt1519 - 1; j >= 0; j--) {
            for (int k = 0; k < width; k++)
                abyte0[i++] = pixels[k + j * width];

        }

        pixels = abyte0;
        anInt1521 = anInt1523 - anInt1519 - anInt1521;
    }

    public void method489(int i, int j, int k, int l) {
        for (int i1 = 0; i1 < palette.length; i1++) {
            int j1 = palette[i1] >> 16 & 0xff;
            j1 += k;
            if (j1 < 0)
                j1 = 0;
            else if (j1 > 255)
                j1 = 255;
            int k1 = palette[i1] >> 8 & 0xff;
            k1 += j;
            if (k1 < 0)
                k1 = 0;
            else if (k1 > 255)
                k1 = 255;
            int l1 = palette[i1] & 0xff;
            l1 += i;
            if (l1 < 0)
                l1 = 0;
            else if (l1 > 255)
                l1 = 255;
            palette[i1] = (j1 << 16) + (k1 << 8) + l1;
        }
    }

    public void drawImage(int y, int x) {
        x += anInt1520;
        y += anInt1521;
        int i1 = x + y * Rasterizer.width;
        int j1 = 0;
        int k1 = anInt1519;
        int l1 = width;
        int i2 = Rasterizer.width - l1;
        int j2 = 0;
        if (y < Rasterizer.topY) {
            int k2 = Rasterizer.topY - y;
            k1 -= k2;
            y = Rasterizer.topY;
            j1 += k2 * l1;
            i1 += k2 * Rasterizer.width;
        }
        if (y + k1 > Rasterizer.bottomY)
            k1 -= (y + k1) - Rasterizer.bottomY;
        if (x < Rasterizer.topX) {
            int l2 = Rasterizer.topX - x;
            l1 -= l2;
            x = Rasterizer.topX;
            j1 += l2;
            i1 += l2;
            j2 += l2;
            i2 += l2;
        }
        if (x + l1 > Rasterizer.bottomX) {
            int i3 = (x + l1) - Rasterizer.bottomX;
            l1 -= i3;
            j2 += i3;
            i2 += i3;
        }
        if (l1 <= 0 || k1 <= 0) {
            return;
        } else {
            method491(j1, Rasterizer.pixels, pixels, j2, palette, k1, l1, i1, false, i2);
            return;
        }
    }

    public void method491(int i, int ai[], byte abyte0[], int j, int ai1[], int k, int l, int i1, boolean flag, int j1) {
        int k1 = -(l >> 2);
        l = -(l & 3);
        for (int l1 = -k; l1 < 0; l1++) {
            for (int i2 = k1; i2 < 0; i2++) {
                byte byte0 = abyte0[i++];
                if (byte0 != 0)
                    ai[i1++] = ai1[byte0 & 0xff];
                else
                    i1++;
                byte0 = abyte0[i++];
                if (byte0 != 0)
                    ai[i1++] = ai1[byte0 & 0xff];
                else
                    i1++;
                byte0 = abyte0[i++];
                if (byte0 != 0)
                    ai[i1++] = ai1[byte0 & 0xff];
                else
                    i1++;
                byte0 = abyte0[i++];
                if (byte0 != 0)
                    ai[i1++] = ai1[byte0 & 0xff];
                else
                    i1++;
            }

            for (int j2 = l; j2 < 0; j2++) {
                byte byte1 = abyte0[i++];
                if (byte1 != 0)
                    ai[i1++] = ai1[byte1 & 0xff];
                else
                    i1++;
            }

            i1 += j1;
            i += j;
        }

    }

}
