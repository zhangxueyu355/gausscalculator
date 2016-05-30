package com.codfish.gausscalcutor;

public class DmsRad {
	public static double p = 180.0 / Math.PI * 3600;

	// 将度分秒化为弧度值
	public static double dms2rad(int d, int m, int s) {
		double dms = (d * 3600.0 + m * 60.0 + s) / p;
		return dms;
	}
	
	//将角度的弧度制化为度
	public static int rad2dms(double a){
		double rad=a*p;
		int d = (int)(rad / 3600.0 + 0.00001);
		rad -= d*3600.0;
        int m = (int)(rad / 60.0 + 0.00001);
        rad -= m * 60.0;
        return d;
	}
	public static int rad2dms(double a,double a1){
		double rad=a*p;
		int d = (int)(rad / 3600.0 + 0.00001);
		rad -= d*3600.0;
        int m = (int)(rad / 60.0 + 0.00001);
        rad -= m * 60.0;
        return m;
	}
	public static int rad2dms(double a,double a2,double a3){
		double rad=a*p;
		int d = (int)(rad / 3600.0 + 0.00001);
		rad -= d*3600.0;
        int m = (int)(rad / 60.0 + 0.00001);
        rad -= m * 60.0;
        return (int) rad;
	}
}