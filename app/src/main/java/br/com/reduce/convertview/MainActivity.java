package br.com.reduce.convertview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.reduce.model.Aluno;
import br.com.reduce.converter.Converter;

import java.io.IOException;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Aluno aluno;
                try {
                    aluno = Converter.toClass(Aluno.class, MainActivity.this);
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putExtra("aluno", aluno);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, aluno.toString(), Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
