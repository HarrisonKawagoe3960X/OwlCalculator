package com.example.harris_hawk.owlcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public double wk(String str) {//掛け算と割り算を処理する
        double temp[]=new double[1000000];
        double result=0;
        int start=0;
        int end=0;
        int index1=0;
        int index2=0;
        int ari[]=new int[1000000];
        boolean begin=true;
        for(int i=0;i<str.length();i++) {

            if(str.substring(i,i+1).equals("*")) {
                end=i;
                temp[index1]=Double.valueOf(str.substring(start,i));
                start=i+1;
                ari[index2]=1; //掛ける
                if(index1==0) {
                    result=temp[index1];
                    begin=false;
                }
                index1++;
                index2++;
            }else if(str.substring(i,i+1).equals("/")) {
                end=i;
                temp[index1]=Double.valueOf(str.substring(start,i));
                start=i+1;
                ari[index2]=2; //割る
                if(index1==0) {
                    result=temp[index1];
                    begin=false;
                }
                index1++;
                index2++;

            }
            else if(i==str.length()-1) {
                temp[index1]=Double.valueOf(str.substring(start));
                index1++;
            }


        }
        int j=0;
        for(int i=0;i<index1;i++) {

            if(i==0) {
                result=temp[i];
            }else if(ari[i-1]==1&&i>0) {
                result*=temp[i];
                j++;
            }else if(ari[i-1]==2&&i>0) {
                result/=temp[i];
                j++;
            }
        }

        return result;
    }

    public double pm(String str) {//足し算と引き算を処理する
        double temp[]=new double[1000000];
        double result=0;
        int start=0;
        int end=0;
        int index1=0;
        int index2=0;
        int ari[]=new int[1000000];
        boolean begin=true;
        for(int i=0;i<str.length();i++) {

            if(str.substring(i,i+1).equals("+")) {
                end=i;
                temp[index1]=Double.valueOf(str.substring(start,i));
                start=i+1;
                ari[index2]=1; //
                if(index1==0) {
                    result=temp[index1];
                    begin=false;
                }
                index1++;
                index2++;
            }else if(str.substring(i,i+1).equals("-")) {
                end=i;
                temp[index1]=Double.valueOf(str.substring(start,i));
                start=i+1;
                ari[index2]=2; //引く
                if(index1==0) {
                    result=temp[index1];
                    begin=false;
                }
                index1++;
                index2++;

            }
            else if(i==str.length()-1) {
                temp[index1]=Double.valueOf(str.substring(start));
                index1++;
            }


        }
        int j=0;
        for(int i=0;i<index1;i++) {

            if(i==0) {
                result=temp[i];
            }else if(ari[i-1]==1&&i>0) {
                result+=temp[i];
                j++;
            }else if(ari[i-1]==2&&i>0) {
                result-=temp[i];
                j++;
            }
        }

        return result;
    }

    public double process(String str) {
        String tmpstr = str;
        int start = 0;
        int end = 0;
        String temp = null;

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("+") || str.substring(i, i + 1).equals("-")) {
                if (end == start || start > end) {
                    end = i;
                    temp = str.substring(start, end);
                    if (temp.contains("*") || temp.contains("/")) {
                        tmpstr = tmpstr.replace(temp, String.valueOf(wk(temp)));
                        temp = String.valueOf(wk(temp));

                    }

                    start = end + 1;
                }
                System.out.print(i+" ");


            }else if (i == (str.length() - 1)) {

                temp = str.substring(start);
                if (temp.contains("*") || temp.contains("/")) {
                    tmpstr = tmpstr.replace(temp, String.valueOf(wk(temp)));
                    temp = String.valueOf(wk(temp));

                }
            }


        }
        double result = pm(tmpstr);
        return result;
    }

    public String kako(String str) {
        double temp[] = new double[1000000];
        double result = 0;
        int start = 0;
        int end = 0;
        int index1 = 0;
        int index2 = 0;
        int ari[] = new int[1000000];
        boolean begin = true;
        for (int i = 0; i < str.length(); i++) {

            if (str.substring(i, i + 1).equals("(")) {
                start=i;
            } else if (str.substring(i, i + 1).equals(")")) {
                end=i;
            }

        }
        String temp2=str.substring(start+1,end);
        result = process(temp2);

        System.out.println();

        String strresult = str.replace(str.substring(start,end+1), String.valueOf(result));



        return strresult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_main);
        final Button zero=super.findViewById(R.id.button0);
        final Button one=super.findViewById(R.id.button1);
        final Button two=super.findViewById(R.id.button2);
        final Button three=super.findViewById(R.id.button3);
        final Button four=super.findViewById(R.id.button4);
        final Button five=super.findViewById(R.id.button5);
        final Button six=super.findViewById(R.id.button6);
        final Button seven=super.findViewById(R.id.button7);
        final Button eight=super.findViewById(R.id.button8);
        final Button nine=super.findViewById(R.id.button9);
        final Button del=super.findViewById(R.id.buttondel);
        final Button plus=super.findViewById(R.id.buttonplus);
        final Button minus=super.findViewById(R.id.buttonminus);
        final Button kakeru=super.findViewById(R.id.buttonkakeru);
        final Button waru=super.findViewById(R.id.buttonwaru);
        final Button point=super.findViewById(R.id.buttonpoint);
        final Button equal=super.findViewById(R.id.buttonequal);
        final TextView result=super.findViewById(R.id.resultmath);
        final Button left =super.findViewById(R.id.buttonleft);
        final Button right=super.findViewById(R.id.buttonright);
        final Button delete=super.findViewById(R.id.buttondelete);
        double temp=0;
        double resultNum=0;



        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"9");
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+".");
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"-");
            }
        });

        kakeru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"*");
            }
        });

        waru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"/");
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+"(");
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(result.getText()+")");
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=result.getText().toString().substring(0,result.length()-1);
                result.setText(text);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = result.getText().toString();
                String tmpstr = str;


                while(str.contains("(")) {
                    str=kako(str);
                }




                double num = process(str);
                if(num%2!=0&&num%3!=0&&num%5!=0&&num%7!=0){
                    result.setText(String.format("%.6f", num));
                }else{
                    result.setText(String.valueOf(num));
                }

            }
        });




}
}
