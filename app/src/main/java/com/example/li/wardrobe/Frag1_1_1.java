package com.example.li.wardrobe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class Frag1_1_1 extends AppCompatActivity {

    private String[] first = new String[]{"上装","外套","裙子","裤子","鞋子","内衣睡衣","首饰","包包","其他"};
    private String[] f_first = new String[]{"衬衫","长袖","短袖","T恤","卫衣","马甲","开衫"};
    private String[][] second = new String[][]{{"衬衫","长袖","短袖","T恤","卫衣","马甲","开衫","其他"},
            {"西装","夹克","风衣","大衣","皮衣","羽绒服","套装","其他"},
            {"短裙","及膝裙","中长裙","长裙","连衣裙","小礼裙","其他裙子"},
            {"直筒裤","哈伦裤","紧身裤","阔腿裤","五分裤","短裤","牛仔裤","连体裤","皮裤","其他裤子"},
            {"平底鞋","低跟鞋(1-3公分)","中跟鞋(4-6公分)","高跟鞋(7公分以上)","裸靴/短靴","长筒靴","凉鞋","运动鞋","休闲鞋","其他"},
            {"文胸","底裤","吊带","打底上衣","打底裤","睡衣","袜子","泳衣","其他"},
            {"耳饰","项链","戒指","胸针","手链/手镯","袖扣/扣帽/丝巾扣","其他"},
            {"肩挎包","手提包","背包","旅行包","钱包","其他"},
            {"帽子","披肩/围巾","手表","腰带","头饰","眼镜","手套","其他"}};

    private Spinner spinner_first;
    private Spinner spinner_second;
    private Context mContext;

    ArrayAdapter<String> adapter1;
    ArrayAdapter<String> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag1_1_1);
        mContext = this;

        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,first);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_first = findViewById(R.id.spinner_first);
        spinner_first.setAdapter(adapter1);
        spinner_first.setOnItemSelectedListener(selectListener);

        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,f_first);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_second = findViewById(R.id.spinner_second);
        spinner_second.setAdapter(adapter2);
    }

    private AdapterView.OnItemSelectedListener selectListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            int pos = spinner_first.getSelectedItemPosition();
            adapter2 = new ArrayAdapter<String>(mContext,android.R.layout.simple_spinner_item,second[pos]);
            spinner_second.setAdapter(adapter2);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

}
