package hcmute.edu.vn.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.View;
import android.view.Window;
import android.os.Bundle;
import android.app.Activity;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {
    TextView input,  output, iptemp;  //Hiển thị
    private Button AC,del,cong, tru, nhan, chia, result, thapphan;  //Các nút chức năng
    private Button num1,num2,num3,num4,num5,num7,num8,num9, num6, num0; //Các nút số
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        AnhXa();
        AC.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho nút xóa hết
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("0");
                iptemp.setText("");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho nút xóa từng ký tự một
            @Override
            public void onClick(View v) {
                StringBuffer str = new StringBuffer(input.getText());
                if(str.length() > 0){
                    str.deleteCharAt(str.length()-1);input.setText(str);
                    if(str.length() > 0) Result(); else output.setText("0");
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {   //Tạo sự kiện cho số 0
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"0");Result(); iptemp.setText("");
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {   //Tạo sự kiện cho số 1
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"1");Result(); iptemp.setText("");
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 2
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"2");Result(); iptemp.setText("");
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 3
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"3");Result(); iptemp.setText("");
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 4
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"4");Result(); iptemp.setText("");
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 5
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"5");Result(); iptemp.setText("");
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 6
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"6");Result(); iptemp.setText("");
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 7
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"7");Result(); iptemp.setText("");
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 8
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"8");Result(); iptemp.setText("");
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho số 9
            @Override
            public void onClick(View v) {
                input.setText(input.getText()+"9"); iptemp.setText("");
                Result();
            }
        });
        thapphan.setOnClickListener(new View.OnClickListener() { //Tạo sự kiện cho chức năng thập phân
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) )  input.setText(input.getText()+".");
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {   //Tạo sự kiện cho chức năng trừ
            @Override
            public void onClick(View v) {
                iptemp.setText("");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"-");
                }
                if(input.getText().length()==0) input.setText(input.getText()+"-");
                else if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) || input.getText().charAt(input.getText().length()-1)=='/' || input.getText().charAt(input.getText().length()-1)=='x' )  input.setText(input.getText()+"-");
            }
        });
        cong.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho chức năng cộng
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)) ) input.setText(input.getText()+"+");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"+");
                }
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {  //Tạo sự kiện cho chức năng nhân
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)))  input.setText(input.getText()+"x");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"x");
                }
            }
        });
        chia.setOnClickListener(new View.OnClickListener() { //Tạo sự kiện cho chức năng chia
            @Override
            public void onClick(View v) {
                if(input.getText().length() >0) if(Character.isDigit(input.getText().charAt(input.getText().length()-1)))  input.setText(input.getText()+"/");
                if(output.getText()!="0" && input.getText()=="")
                {
                    input.setText(output.getText()+"/");
                }
            }
        });
        result.setOnClickListener(new View.OnClickListener() { //Tạo sự kiện cho chức năng xuất ra kết quả
            @Override
            public void onClick(View v) {
                if(input.getText().length() > 1 ) Result();
                iptemp.setText((String)input.getText()+" =");
                input.setText("");
            }
        });
    }
    private ArrayList<String> arrOperation;  //Mảng toán tử
    private ArrayList<Double> arrNumber;    //Mảng số
    public int addOperation(String input) {
        arrOperation = new ArrayList<>();
        addNumber(this.input.getText().toString());
        if(this.input.getText().charAt(0)=='-') arrNumber.set(0,-arrNumber.get(0));
        char[] cArray = input.toCharArray();
        for (int i = 1; i < cArray.length; i++) { //Xét dấu
            switch (cArray[i]) {
                case '+':
                    arrOperation.add(cArray[i] + "");
                    break;
                case '-':
                    arrOperation.add(cArray[i] + "");
                    break;
                case 'x':
                    arrOperation.add(cArray[i] + "");
                    if(i<cArray.length-1) if(cArray[i+1] =='-' && i+1 <cArray.length-1 )
                    {
                        arrNumber.set(arrOperation.size(),-arrNumber.get(arrOperation.size()));
                        i++;
                    }
                    break;
                case '/':
                    arrOperation.add(cArray[i] + "");
                    if(i<cArray.length-1) if(cArray[i+1] =='-' && i+1 <cArray.length-1 )
                    {
                        arrNumber.set(arrOperation.size(),-arrNumber.get(arrOperation.size()));
                        i++;
                    }
                    break;
                default:
                    break;
            }
        }
        return 0;
    } //Xét lấy dấu

    public void addNumber(String stringInput) {   //Xét lấy số
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)"); //Một biểu thức chính quy (regex) được tạo để tìm kiếm các số trong chuỗi đầu vào
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1))); //Vòng lặp tìm số
        }
    }
    public void Result() //Thực hiện phép tính
    {
        DecimalFormat df = new DecimalFormat("###.#######");
        double result = 0;
        addOperation(input.getText().toString());
        if(arrNumber.size()==1)  result = arrNumber.get(0);
        if(arrOperation.size()>arrNumber.size() ||arrOperation.size()<0){
            output.setText("Input error!!");
        }else {
            for (int i = 0; i < (arrNumber.size() - 1); i++) {
                switch (arrOperation.get(i)) {
                    case "x":
                        arrNumber.set(i, arrNumber.get(i) * arrNumber.get(i + 1));
                        arrNumber.remove(i+1); arrOperation.remove(i);
                        i--;
                        break;
                    case "/":
                        arrNumber.set(i, arrNumber.get(i) / arrNumber.get(i + 1));
                        arrNumber.remove(i+1); arrOperation.remove(i);
                        i--;
                    default:
                        break;
                }
            }
            result = arrNumber.get(0);
            for (int i = 0; i < (arrNumber.size() - 1); i++) {
                switch (arrOperation.get(i)) {
                    case "+":
                        result = result + arrNumber.get(i + 1);
                        break;
                    case "-":
                        result = result - arrNumber.get(i + 1);
                        break;
                    default:
                        break;
                }
            }
            output.setText(df.format(result) + "");
        }
    }
    public void AnhXa()  //Ánh xạ cấu hình tương ứng
    {
        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        AC = (Button) findViewById(R.id.AC);
        thapphan = (Button)findViewById(R.id.thapphan);
        del = (Button) findViewById(R.id.Delete);
        cong = (Button) findViewById(R.id.daucong);
        tru = (Button) findViewById(R.id.dautru);
        nhan = (Button) findViewById(R.id.phepnhan);
        chia = (Button) findViewById(R.id.phepchia);
        result = (Button) findViewById(R.id.result);
        num0 = (Button) findViewById(R.id.num0);
        num1 = (Button) findViewById(R.id.num1);
        num2 = (Button) findViewById(R.id.num2);
        num3 = (Button) findViewById(R.id.num3);
        num4 = (Button) findViewById(R.id.num4);
        num5 = (Button) findViewById(R.id.num5);
        num6 = (Button) findViewById(R.id.num6);
        num7 = (Button) findViewById(R.id.num7);
        num8 = (Button) findViewById(R.id.num8);
        num9 = (Button) findViewById(R.id.num9);
        iptemp =(TextView)findViewById(R.id.iptemp);
    }
}