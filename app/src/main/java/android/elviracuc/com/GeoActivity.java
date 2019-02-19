package android.elviracuc.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.elviracuc.android.model.BancoDePreguntas;
import com.elviracuc.android.model.Pregunta;

public class GeoActivity extends AppCompatActivity {

    private TextView mTextoPregunta;
    private Button mBotonCierto;
    private Button mBotonFalso;
    private Button mBotonAnterior;
    private Button mBotonSiguiente;

    private BancoDePreguntas mBanco;
    private Pregunta mPreguntaActual;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo);

        mTextoPregunta = findViewById(R.id.texto_pregunta);
        mBotonSiguiente = findViewById(R.id.boton_siguiente);
        mBotonCierto = findViewById(R.id.boton_cierto);
        mBotonFalso = findViewById(R.id.boton_falso);
        mBotonAnterior = findViewById(R.id.boton_anterior);

        crearBancoDePreguntas();
        actualizarPregunta();

        mBotonCierto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(true);
            }
        });
        mBotonFalso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verificarRespuesta(false);
            }
        });
        mBotonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = mBanco.previous();
                actualizarPregunta();
            }
        });
        mBotonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPreguntaActual = mBanco.next();
                actualizarPregunta();
            }
        });
    }

    private void crearBancoDePreguntas() {
        mBanco = new BancoDePreguntas();
        mBanco.add(new Pregunta(R.string.texto_pregunta_1, false));
        mBanco.add(new Pregunta(R.string.texto_pregunta_2, true));
        mBanco.add(new Pregunta(R.string.texto_pregunta_3, true));
        mBanco.add(new Pregunta(R.string.texto_pregunta_4, true));
        mBanco.add(new Pregunta(R.string.texto_pregunta_5, false));
        mPreguntaActual = mBanco.get(0);
    }

    private void actualizarPregunta() {
        mTextoPregunta.setText(mPreguntaActual.getIdResTexto());
    }

    private void verificarRespuesta(boolean botonOprimido) {
        boolean respuesta = mPreguntaActual.isRespuestaVerdadera();
        if (botonOprimido == respuesta) {
            Toast.makeText(GeoActivity.this,
                    R.string.texto_respuesta_correcta,
                    Toast.LENGTH_SHORT)
                    .show();
        }
        else {
            Toast.makeText(GeoActivity.this,
                    R.string.texto_respuesta_incorrecta,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}

