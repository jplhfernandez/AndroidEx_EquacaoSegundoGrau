package com.jp.ex2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import controller.ControllerEquacao;

public class MainActivity extends AppCompatActivity {

    private EditText etNumA;
    private EditText etNumB;
    private EditText etNumC;
    private Button btnCalcular;
    private TextView tvX1;
    private TextView tvX2;
    private TextView tvDelta;
    private TextView tvErro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etNumA =findViewById(R.id.etNumA);
        etNumB =findViewById(R.id.etNumB);
        etNumC =findViewById(R.id.etNumC);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvX1 = findViewById(R.id.tvX1);
        tvX2 = findViewById(R.id.tvX2);
        tvDelta = findViewById(R.id.tvDelta);
        tvErro = findViewById(R.id.tvErro);

        btnCalcular.setOnClickListener(operacao -> Equacao());
    }
    private void Equacao() {
        double NumA = Double.parseDouble(etNumA.getText().toString());
        double NumB = Double.parseDouble(etNumB.getText().toString());
        double NumC = Double.parseDouble(etNumC.getText().toString());

        ControllerEquacao controller = new ControllerEquacao();

        double delta = controller.Delta(NumA, NumB, NumC);
        tvDelta.setText("Delta = " + delta);

        if (NumA == 0) {
            tvErro.setText("Erro: A não pode ser zero.");
            tvX1.setText("");
            tvX2.setText("");
            return;
        }

        if (delta < 0) {
            tvErro.setText("Erro: Delta negativo. Sem raízes reais.");
            tvX1.setText("");
            tvX2.setText("");
            return;
        }

        double x1 = controller.x1(NumA, NumB, NumC);
        double x2 = controller.x2(NumA, NumB, NumC);

        tvErro.setText("");
        tvX1.setText("x1 = " + x1);
        tvX2.setText("x2 = " + x2);
    }
}