package net.minecraft.util;

public class Matrix4f extends org.lwjgl.util.vector.Matrix4f
{
    public Matrix4f(float[] matrix4f)
    {
        this.m00 = matrix4f[0];
        this.m01 = matrix4f[1];
        this.m02 = matrix4f[2];
        this.m03 = matrix4f[3];
        this.m10 = matrix4f[4];
        this.m11 = matrix4f[5];
        this.m12 = matrix4f[6];
        this.m13 = matrix4f[7];
        this.m20 = matrix4f[8];
        this.m21 = matrix4f[9];
        this.m22 = matrix4f[10];
        this.m23 = matrix4f[11];
        this.m30 = matrix4f[12];
        this.m31 = matrix4f[13];
        this.m32 = matrix4f[14];
        this.m33 = matrix4f[15];
    }

    public Matrix4f()
    {
        this.m00 = this.m01 = this.m02 = this.m03 = this.m10 = this.m11 = this.m12 = this.m13 = this.m20 = this.m21 = this.m22 = this.m23 = this.m30 = this.m31 = this.m32 = this.m33 = 0.0F;
    }
}
