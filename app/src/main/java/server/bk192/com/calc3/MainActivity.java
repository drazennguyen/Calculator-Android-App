package server.bk192.com.calc3;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static server.bk192.com.calc3.MainActivity.STATE.FIRST_OP;
import static server.bk192.com.calc3.MainActivity.STATE.RESET_SECOND_OP;
import static server.bk192.com.calc3.MainActivity.STATE.SECOND_OP;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0, btn_Add, btn_Sub, btn_Mul, btn_Div, btn_Mod, btn_calc, btn_dec, btn_del, btn_clear;
    EditText ed1;

    float Value1, Value2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);

        btn_1 = findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);

        btn_2 = findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);

        btn_3 = findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);

        btn_4 = findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);

        btn_5 = findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);

        btn_6 = findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);

        btn_7 = findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);

        btn_8 = findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);

        btn_9 = findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);

        btn_dec = findViewById(R.id.btn_dec);
        btn_dec.setOnClickListener(this);

        btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(this);

        btn_Div = findViewById(R.id.btn_Div);
        btn_Div.setOnClickListener(this);

        btn_Sub = findViewById(R.id.btn_Sub);
        btn_Sub.setOnClickListener(this);

        btn_Mul = findViewById(R.id.btn_Mul);
        btn_Mul.setOnClickListener(this);

        btn_Mod = findViewById(R.id.btn_Mod);
        btn_Mod.setOnClickListener(this);

        btn_calc = findViewById(R.id.btn_calc);
        btn_calc.setOnClickListener(this);

        btn_del = findViewById(R.id.btn_del);
        btn_del.setOnClickListener(this);

        btn_clear = findViewById(R.id.btn_clear);
        btn_clear.setOnClickListener(this);

        ed1 = findViewById(R.id.edText1);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Value2 = Float.parseFloat(ed1.getText() + "");

                if (operator == "ADD") {

                    ed1.setText(Value1 + Value2 + "");
                    operator = "";
                }


                if (operator == "SUB") {
                    ed1.setText(Value1 - Value2 + "");
                    operator = "";
                }

                if (operator == "MUL") {
                    ed1.setText(Value1 * Value2 + "");
                    operator = "";
                }

                if (operator == "DIV") {
                    ed1.setText(Value1 / Value2 + "");
                    operator = "";
                }

                if (operator == "MOD") {
                    ed1.setText(Value1 % Value2 + "");
                    operator = "";
                }
            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ed1.getText().toString();
                s = s.substring(0, s.length() - 1);
                ed1.setText(s);
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed1.setText("");
            }
        });
    }

    public enum STATE {
        FIRST_OP, RESET_SECOND_OP, SECOND_OP
    }

    STATE state = FIRST_OP;
    double first_op = 0, second_op = 0;
    String operator;


    @Override
    public void onClick(View v) {
        switch (state) {
            case FIRST_OP:
                if (v.getId() == R.id.btn_0 || v.getId() == R.id.btn_1 || v.getId() == R.id.btn_2 || v.getId() == R.id.btn_3 || v.getId() == R.id.btn_4
                        || v.getId() == R.id.btn_5 || v.getId() == R.id.btn_6 || v.getId() == R.id.btn_7 || v.getId() == R.id.btn_8 || v.getId() == R.id.btn_9
                        || v.getId() == R.id.btn_dec) {
                    String displayNumber = ((Button) v).getText().toString();
                    if (ed1.getText().toString().equals("0") == true) {
                        ed1.setText(displayNumber);
                    } else {
                        ed1.setText(ed1.getText() + displayNumber);
                    }

                }
                if (v.getId() == R.id.btn_Add) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "ADD";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }

                if (v.getId() == R.id.btn_Sub) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "SUB";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }


                if (v.getId() == R.id.btn_Mul) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "MUL";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }

                if (v.getId() == R.id.btn_Div) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "DIV";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }

                if (v.getId() == R.id.btn_Mod) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "MOD";
                        ed1.setText(null);
                    }

                    state = RESET_SECOND_OP;
                }
                break;
            case RESET_SECOND_OP:
                if (v.getId() == R.id.btn_0 || v.getId() == R.id.btn_1 || v.getId() == R.id.btn_2 || v.getId() == R.id.btn_3 || v.getId() == R.id.btn_4
                        || v.getId() == R.id.btn_5 || v.getId() == R.id.btn_6 || v.getId() == R.id.btn_7 || v.getId() == R.id.btn_8 || v.getId() == R.id.btn_9
                        || v.getId() == R.id.btn_dec) {
                    String displayNumber = ((Button) v).getText().toString();
                    ed1.setText(ed1.getText() + displayNumber);
                    state = SECOND_OP;
                }
                break;
            case SECOND_OP:
                if (v.getId() == R.id.btn_0 || v.getId() == R.id.btn_1 || v.getId() == R.id.btn_2 || v.getId() == R.id.btn_3 || v.getId() == R.id.btn_4
                        || v.getId() == R.id.btn_5 || v.getId() == R.id.btn_6 || v.getId() == R.id.btn_7 || v.getId() == R.id.btn_8 || v.getId() == R.id.btn_9
                        || v.getId() == R.id.btn_dec) {
                    String displayNumber = ((Button) v).getText().toString();
                    ed1.setText(ed1.getText() + displayNumber);
                }

                if (v.getId() == R.id.btn_Add) {
                    second_op = Double.parseDouble(ed1.getText().toString());
                    first_op += second_op;

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "ADD";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }


                if (v.getId() == R.id.btn_Sub) {
                    second_op = Double.parseDouble(ed1.getText().toString());
                    first_op += second_op;

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "SUB";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }


                if (v.getId() == R.id.btn_Mul) {
                    second_op = Double.parseDouble(ed1.getText().toString());
                    first_op += second_op;

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "MUL";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }

                if (v.getId() == R.id.btn_Div) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "DIV";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }

                if (v.getId() == R.id.btn_Mod) {
                    first_op = Double.parseDouble(ed1.getText().toString());

                    if (ed1 == null) {
                        ed1.setText("");
                    } else {
                        Value1 = Float.parseFloat(ed1.getText() + "");
                        operator = "MOD";
                        ed1.setText(null);
                    }
                    state = RESET_SECOND_OP;
                }
                break;
            default:
                break;
        }
    }
}
