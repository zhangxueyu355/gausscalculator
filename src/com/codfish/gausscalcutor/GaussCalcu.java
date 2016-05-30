package com.codfish.gausscalcutor;

public class GaussCalcu {
	public static double a,b,e,B,L,l,L0,X,N,t,eta,e1,x,y,e_2,Bf,Mf,Nf,tf,etaf_2,e1_2;
	public static double a0,a2,a4,a6,a8,m0,m2,m4,m6,m8;
	public static double GaussPositive(){		
		a=MainActivity.a;
		b=MainActivity._b;
		e=Math.sqrt((a*a-b*b)/a/a);
		e1=Math.sqrt((a*a-b*b)/b/b);
		e_2=MainActivity.e2;
		B=MainActivity.Brad;
		L=MainActivity.Lrad;
		L0=MainActivity.L0;
		L0=AtoR(L0);
		m0 = a * (1 - e_2);
        m2 = 3.0 / 2.0 * e_2 * m0;
        m4 = 5.0 / 4.0 * e_2 * m2;
        m6 = 7.0 / 6.0 * e_2 * m4;
        m8 = 9.0 / 8.0 * e_2 * m6;
        a0 = m0 + m2 / 2.0 + m4 * 3.0 / 8.0 + 5.0 * m6 / 16.0 + m8 * 35.0 / 128.0;
        a2 = m2 / 2.0 + m4 / 2.0 + m6 * 15.0 / 32.0 + m8 * 7.0 / 16.0;
        a4 = m4 / 8.0 + m6 * 3.0 / 16.0 + m8 * 7.0 / 32.0;
        a6 = m6 / 32.0 + m8 / 16.0;
        a8 = m8 / 128.0;
        X=a0*B-a2/2.0*Math.sin(B*2.0)+a4/4.0*Math.sin(B*4.0)-a6/6.0*Math.sin(B*6.0)+a8/8.0*Math.sin(B*8.0);
		N=a/Math.sqrt(1-e*e*Math.sin(B)*Math.sin(B));		
		t=Math.tan(B);
		l=L-L0;
		eta=e1*Math.cos(B);
		x=X+Math.pow(l, 2)/2.0*N*Math.sin(B)*Math.cos(B)+Math.pow(l, 4)/24.0*N*Math.sin(B)*Math.pow(Math.cos(B), 3)*(5-Math.pow(t, 2)+9*Math.pow(eta, 2)+4*Math.pow(eta, 4))+Math.pow(l, 6)/720.0*N*Math.sin(B)*Math.pow(Math.cos(B), 5)*(61-58*Math.pow(t, 2)+Math.pow(t, 4));
		y=l*N*Math.cos(B)+Math.pow(l, 3)/6.0*N*Math.pow(Math.cos(B), 3)*(1-Math.pow(t, 2)+Math.pow(eta, 2))+Math.pow(l, 5)/120.0*N*Math.pow(Math.cos(B), 5)*(5-18*Math.pow(t, 2)+Math.pow(t, 4)+14.0*Math.pow(eta, 2)-58*Math.pow(eta, 2)*Math.pow(t, 2));
		return x;		
	}
	
	public static double GaussPositive(double abc){		
		a=MainActivity.a;
		b=MainActivity._b;
		e=Math.sqrt((a*a-b*b)/a/a);
		e1=Math.sqrt((a*a-b*b)/b/b);
		e_2=MainActivity.e2;
		B=MainActivity.Brad;
		L=MainActivity.Lrad;
		L0=MainActivity.L0;
		L0=AtoR(L0);
		m0 = a * (1 - e_2);
        m2 = 3.0 / 2.0 * e_2 * m0;
        m4 = 5.0 / 4.0 * e_2 * m2;
        m6 = 7.0 / 6.0 * e_2 * m4;
        m8 = 9.0 / 8.0 * e_2 * m6;
        a0 = m0 + m2 / 2.0 + m4 * 3.0 / 8.0 + 5.0 * m6 / 16.0 + m8 * 35.0 / 128.0;
        a2 = m2 / 2.0 + m4 / 2.0 + m6 * 15.0 / 32.0 + m8 * 7.0 / 16.0;
        a4 = m4 / 8.0 + m6 * 3.0 / 16.0 + m8 * 7.0 / 32.0;
        a6 = m6 / 32.0 + m8 / 16.0;
        a8 = m8 / 128.0;
        X=a0*B-a2/2.0*Math.sin(B*2.0)+a4/4.0*Math.sin(B*4.0)-a6/6.0*Math.sin(B*6.0)+a8/8.0*Math.sin(B*8.0);
		N = a / Math.sqrt(1 - e * e * Math.sin(B) * Math.sin(B));
		t = Math.tan(B);
		l = L - L0;
		eta = e1 * Math.cos(B);
		x = X + Math.pow(l, 2) / 2.0 * N * Math.sin(B) * Math.cos(B)
				+ Math.pow(l, 4) / 24.0 * N * Math.sin(B) * Math.pow(Math.cos(B), 3)
						* (5 - Math.pow(t, 2) + 9 * Math.pow(eta, 2) + 4 * Math.pow(eta, 4))
				+ Math.pow(l, 6) / 720.0 * N * Math.sin(B) * Math.pow(Math.cos(B), 5)
						* (61 - 58 * Math.pow(t, 2) + Math.pow(t, 4));
		y = l * N * Math.cos(B)
				+ Math.pow(l, 3) / 6.0 * N * Math.pow(Math.cos(B), 3) * (1 - Math.pow(t, 2) + Math.pow(eta, 2))
				+ Math.pow(l, 5) / 120.0 * N * Math.pow(Math.cos(B), 5) * (5 - 18 * Math.pow(t, 2) + Math.pow(t, 4)
						+ 14.0 * Math.pow(eta, 2) - 58 * Math.pow(eta, 2) * Math.pow(t, 2));
		return y;		
	}
	
	public static double GaussNegative(double abc) {
		a=MainActivity.a;
		b=MainActivity._b;
		e=Math.sqrt((a*a-b*b)/a/a);
		e1=Math.sqrt((a*a-b*b)/b/b);
		e_2=MainActivity.e2;
		e1_2=MainActivity.e1_2;
		L0=MainActivity.L0;
		m0 = a * (1 - e_2);
        m2 = 3.0 / 2.0 * e_2 * m0;
        m4 = 5.0 / 4.0 * e_2 * m2;
        m6 = 7.0 / 6.0 * e_2 * m4;
        m8 = 9.0 / 8.0 * e_2 * m6;
        a0 = m0 + m2 / 2.0 + m4 * 3.0 / 8.0 + 5.0 * m6 / 16.0 + m8 * 35.0 / 128.0;
        a2 = m2 / 2.0 + m4 / 2.0 + m6 * 15.0 / 32.0 + m8 * 7.0 / 16.0;
        a4 = m4 / 8.0 + m6 * 3.0 / 16.0 + m8 * 7.0 / 32.0;
        a6 = m6 / 32.0 + m8 / 16.0;
        a8 = m8 / 128.0;
        X=MainActivity.x;
        x=X;
        y=MainActivity.y;
        L0=AtoR(L0);
        Bf=Bf(X, 1E-10);
        Mf=a*(1-e_2)/Math.pow(Math.sqrt(1-e_2*Math.pow(Math.sin(Bf), 2)), 3);
        Nf=a/Math.sqrt(1-e_2*Math.pow(Math.sin(Bf), 2));
        etaf_2=Math.pow(e1_2, 2)*Math.pow(Math.cos(Bf), 2);
        tf=Math.tan(Bf);
        B=Bf-(Math.pow(y,2)*tf)/(2*Mf*Nf)+Math.pow(y, 4)*tf*(5+3*Math.pow(tf, 2)+etaf_2-9*etaf_2*Math.pow(tf, 2))/(24*Mf*Math.pow(Nf, 3))-Math.pow(y, 6)*tf*(61+90*Math.pow(tf, 2)+45*Math.pow(tf, 4))/(720*Mf*Math.pow(Nf, 5));
        l=y/(Nf*Math.cos(Bf))-Math.pow(y, 3)*(1+2*Math.pow(tf, 2)+etaf_2)/(6*Math.pow(Nf, 3)*Math.pow(Nf, 3)*Math.cos(Bf))+Math.pow(y, 5)*(5+28*Math.pow(tf, 2)+24*Math.pow(tf, 4)+6*etaf_2*Math.pow(tf, 2))/(120*Math.pow(Nf, 5)*Math.cos(Bf));
        L=L0+l;
		return L;
	}
	
	public static double GaussNegative() {
		a=MainActivity.a;
		b=MainActivity._b;
		e=Math.sqrt((a*a-b*b)/a/a);
		e1=Math.sqrt((a*a-b*b)/b/b);
		e_2=MainActivity.e2;
		e1_2=MainActivity.e1_2;
		L0=MainActivity.L0;
		m0 = a * (1 - e_2);
        m2 = 3.0 / 2.0 * e_2 * m0;
        m4 = 5.0 / 4.0 * e_2 * m2;
        m6 = 7.0 / 6.0 * e_2 * m4;
        m8 = 9.0 / 8.0 * e_2 * m6;
        a0 = m0 + m2 / 2.0 + m4 * 3.0 / 8.0 + 5.0 * m6 / 16.0 + m8 * 35.0 / 128.0;
        a2 = m2 / 2.0 + m4 / 2.0 + m6 * 15.0 / 32.0 + m8 * 7.0 / 16.0;
        a4 = m4 / 8.0 + m6 * 3.0 / 16.0 + m8 * 7.0 / 32.0;
        a6 = m6 / 32.0 + m8 / 16.0;
        a8 = m8 / 128.0;
        x=MainActivity.x;
        y=MainActivity.y;
        L0=AtoR(L0);
        Bf=Bf(x, 1E-10);
        Mf=a*(1-e_2)/Math.pow(Math.sqrt(1-e_2*Math.pow(Math.sin(Bf), 2)), 3);
        Nf=a/Math.sqrt(1-e_2*Math.pow(Math.sin(Bf), 2));
        etaf_2=Math.pow(e1_2, 2)*Math.pow(Math.cos(Bf), 2);
        tf=Math.tan(Bf);
        B=Bf-(Math.pow(y,2)*tf)/(2*Mf*Nf)+Math.pow(y, 4)*tf*(5+3*Math.pow(tf, 2)+etaf_2-9*etaf_2*Math.pow(tf, 2))/(24*Mf*Math.pow(Nf, 3))-Math.pow(y, 6)*tf*(61+90*Math.pow(tf, 2)+45*Math.pow(tf, 4))/(720*Mf*Math.pow(Nf, 5));
        l=y/(Nf*Math.cos(Bf))-Math.pow(y, 3)*(1+2*Math.pow(tf, 2)+etaf_2)/(6*Math.pow(Nf, 3)*Math.pow(Nf, 3)*Math.cos(Bf))+Math.pow(y, 5)*(5+28*Math.pow(tf, 2)+24*Math.pow(tf, 4)+6*etaf_2*Math.pow(tf, 2))/(120*Math.pow(Nf, 5)*Math.cos(Bf));
        L=L0+l;
		return B;
	}
	
	public static double Bf(double X, double acry) {
		double B0 = X / a0;
		double B1 = 0;
		while (Math.abs(B1 - B0) >= acry) {
			B1 = B0;
			B0 = (X + a2 / 2.0 * Math.sin(B1 * 2.0) - a4 / 4.0 * Math.sin(B1 * 4.0) + a6 / 6.0 * Math.sin(B1 * 6.0)
					- a8 / 8.0 * Math.sin(B1 * 8.0)) / a0;
		}
		return B0;
	}

//角度转化弧度
	public static double AtoR(double x) {
		x = x * Math.PI / 180;
		return x;
	}
//弧度转化角度
	public static double RtoA(double x) {
		x = x * 180 / Math.PI;
		return x;
	}
}
