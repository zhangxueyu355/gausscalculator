package com.codfish.gausscalcutor;

import java.util.ArrayList;
import java.util.List;

import com.codfish.gausscalcutor.DmsRad;
import com.codfish.gausscalcutor.GaussCalcu;
import com.codfish.meridianonly.R;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	private Spinner spinner;
	private List<String> list;
	private ArrayAdapter<String> adapter;
	private TextView textView_a, textView_A;
	public static int a;// 椭球长半轴,默认WGS84
	public static double _A = 298.257223563;// 扁率倒数
	public static double e2;// 第一偏心率平方
	public static double e1_2;// 第二偏心率平方
	public static double B;// 纬度
	public static double L;// 经度
	public static double L0;// 中央子午线经度
	public static int num;// 带号
	public static double X;
	public static double _b;// 椭球短板轴；
	public int d, m, s;// 度分秒
	public double Rad, A;

	public double len;// 长度
	public static double Brad, Lrad;// 弧度
	public static double x, y, b, l;// 平面坐标与经纬度变量
	private Button bt1, bt2, bt_cl;
	DmsRad trans = new DmsRad();
	GaussCalcu gaussCalcu = new GaussCalcu();
	double[] output = new double[2];// 接收结果数组
	private EditText editText_B_d, editText_B_m, editText_B_s, editText_L_d, editText_L_m, editText_L_s, editText_x,
			editText_y, editText_num, editText_cor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		bt_cl = (Button) findViewById(R.id.button3);
		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
		bt_cl.setOnClickListener(this);
		editText_B_d = (EditText) findViewById(R.id.EditText01);
		editText_B_m = (EditText) findViewById(R.id.EditText02);
		editText_B_s = (EditText) findViewById(R.id.editText3);
		editText_L_d = (EditText) findViewById(R.id.editText4);
		editText_L_m = (EditText) findViewById(R.id.editText5);
		editText_L_s = (EditText) findViewById(R.id.editText6);
		editText_x = (EditText) findViewById(R.id.editText1_x);
		editText_y = (EditText) findViewById(R.id.editText2_y);
		editText_num = (EditText) findViewById(R.id.editText1_num);
		editText_cor = (EditText) findViewById(R.id.editText2_cor);
		editText_cor.setText("" + 500000);
		textView_a = (TextView) findViewById(R.id.textView_a);
		textView_A = (TextView) findViewById(R.id.textView_A);
		spinner = (Spinner) findViewById(R.id.spinner1);
		list = new ArrayList<String>();
		list.add("WGS84椭球");
		list.add("克拉索夫斯基椭球");
		list.add("1975国际椭球");
		list.add("2000中国大地坐标系");
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
		case 0:
			a = 6378137;
			_b = 6356752.3142;
			_A = 298.257223563;
			e2 = 0.00669437999013;
			e1_2 = 0.00673949674227;
			textView_a.setText("" + a);
			textView_A.setText("" + _A);
			break;
		case 1:
			a = 6378245;
			_A = 298.3;
			_b = 6356863.0187730473;
			e2 = 0.006693421622966;
			e1_2 = 0.006738525414683;
			textView_a.setText("" + a);
			textView_A.setText("" + _A);
			break;
		case 2:
			a = 6378140;
			_b = 6356755.2881575287;
			_A = 298.257;
			e2 = 0.006694384999588;
			e1_2 = 0.006739501819473;
			textView_a.setText("" + a);
			textView_A.setText("" + _A);
			break;
		case 3:
			a = 6378137;
			_b = 6356752.3141;
			_A = 298.257222101;
			e2 = 0.00669438002290;
			e1_2 = 0.00673949677548;
			textView_a.setText("" + a);
			textView_A.setText("" + _A);
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		// 正算button
		case R.id.button1: {
			Brad = trans.dms2rad(Integer.valueOf(editText_B_d.getText().toString()),
					Integer.valueOf(editText_B_m.getText().toString()),
					Integer.valueOf(editText_B_s.getText().toString()));
			Lrad = trans.dms2rad(Integer.valueOf(editText_L_d.getText().toString()),
					Integer.valueOf(editText_L_m.getText().toString()),
					Integer.valueOf(editText_L_s.getText().toString()));
			num = Integer.valueOf(editText_num.getText().toString());
			if (num >= 13 && num <= 23) {
				L0 = 6 * num - 3;
			} else if (num >= 24 && num <= 45) {
				L0 = 3 * num;
			} else {
				new AlertDialog.Builder(MainActivity.this).setTitle("带号输入错误")//
						.setMessage("带号输入范围13-45,请重新输入")//
						.setPositiveButton("确定", null).show();
			}
			x = gaussCalcu.GaussPositive();
			y = gaussCalcu.GaussPositive(a) + Integer.valueOf(editText_cor.getText().toString());
			editText_x.setText("" + x);
			editText_y.setText("" + num + y);
		}
			break;
		// 反算button
		case R.id.button2: {
			num = Integer.valueOf(editText_num.getText().toString());
			if (num >= 13 && num <= 23) {
				L0 = 6 * num - 3;
			} else if (num >= 24 && num <= 45) {
				L0 = 3 * num;
			} else {
				new AlertDialog.Builder(MainActivity.this).setTitle("带号输入错误")//
						.setMessage("带号输入范围13-45,请重新输入")//
						.setPositiveButton("确定", null).show();
			}
			x = Double.valueOf(editText_x.getText().toString());
			y = Double.valueOf(editText_y.getText().toString()) - Integer.valueOf(editText_cor.getText().toString())
					- num * 1000000;
			Brad=gaussCalcu.GaussNegative();
			Lrad=gaussCalcu.GaussNegative(0);
			editText_B_d.setText(""+trans.rad2dms(Brad));
			editText_B_m.setText(""+trans.rad2dms(Brad, 0));
			editText_B_s.setText(""+trans.rad2dms(Brad, 0, 0));
			editText_L_d.setText(""+trans.rad2dms(Lrad));
			editText_L_m.setText(""+trans.rad2dms(Lrad, 0));
			editText_L_s.setText(""+trans.rad2dms(Lrad, 0, 0));
		}
			break;
		// clear button
		case R.id.button3: {
			editText_num.setText("");
			editText_B_d.setText("");
			editText_B_m.setText("");
			editText_B_s.setText("");
			editText_L_d.setText("");
			editText_L_m.setText("");
			editText_L_s.setText("");
			editText_x.setText("");
			editText_y.setText("");
		}
			break;
		}
	}
}
