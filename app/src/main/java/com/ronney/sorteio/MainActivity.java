package com.ronney.sorteio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textoResultado;
    TextView numMin;
    TextView numMax;

    int minimo = 0;
    int maximo = 0;
    int ramdom = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processUI();
    }

    private void processUI() {
        this.textoResultado = findViewById(R.id.textoResultado);
        this.numMin = findViewById(R.id.numMin);
        this.numMax = findViewById(R.id.numMax);
    }

    public void selecionarBotao(View v) {
        processRamdom(processValues());
    }

    private boolean processValues() {
        boolean error = false;

        if (numMin.getText().length() == 0) {
            error = true;
        } else {
            this.minimo = Integer.parseInt(numMin.getText().toString());
        }

        if (numMax.getText().length() == 0) {
            error = true;
        } else {
            this.maximo = Integer.parseInt(numMax.getText().toString());
        }

        if (error == false) {
            if (this.maximo <= this.minimo) {
                error = true;
            }
        }

        if (error == true) {
            textoResultado.setText("Os valores digitados são inválidos ");
        }

        return error;
    }

    private void processRamdom(Boolean error) {
        if (error == false) {
            ramdom = new Random().nextInt(this.maximo - this.minimo) + this.minimo + 1;
            textoResultado.setText("O Número Sorteado foi: " + ramdom);
        }
    }
}
